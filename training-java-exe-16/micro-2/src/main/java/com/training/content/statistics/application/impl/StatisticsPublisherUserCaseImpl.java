package com.training.content.statistics.application.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.content.statistics.application.StatisticsPublisherUseCase;
import com.training.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class StatisticsPublisherUserCaseImpl implements StatisticsPublisherUseCase {

    private String statisticsTopic;

    public KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public StatisticsPublisherUserCaseImpl(@Value("${kafka.statistics-topic}") String statisticsTopic,
                                           KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.statisticsTopic = statisticsTopic;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendStatisticsMessage(StatisticsOutputDto statistics) throws JsonProcessingException, ExecutionException, InterruptedException {

        String jsonObject = objectMapper.writeValueAsString(statistics);

        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>(statisticsTopic, "", jsonObject);

        SendResult<String, String> result = kafkaTemplate.send(producerRecord).get();

        log.info("Message sent to topic {} offset {} partition {}",
                statisticsTopic, result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
    }
}
