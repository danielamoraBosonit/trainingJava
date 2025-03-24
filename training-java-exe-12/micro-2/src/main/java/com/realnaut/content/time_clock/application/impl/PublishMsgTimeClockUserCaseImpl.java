package com.realnaut.content.time_clock.application.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnaut.content.time_clock.application.PublishMsgTimeClockUseCase;
import com.realnaut.content.time_clock.infrastructure.controller.dto.TimeClockOutputDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class PublishMsgTimeClockUserCaseImpl implements PublishMsgTimeClockUseCase {

    private String timeClockTopic;

    public KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public PublishMsgTimeClockUserCaseImpl(@Value("${kafka.time-clock-topic}") String timeClockTopic,
                                           KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.timeClockTopic = timeClockTopic;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendTimeClockMessage(TimeClockOutputDto timeClock) throws JsonProcessingException, ExecutionException, InterruptedException {

        String jsonObject = objectMapper.writeValueAsString(timeClock);

        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>(timeClockTopic, "", jsonObject);

        SendResult<String, String> result = kafkaTemplate.send(producerRecord).get();

        log.info("Message sent key {} topic {} offset {} partition {}",
                "", timeClockTopic, result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
    }
}



