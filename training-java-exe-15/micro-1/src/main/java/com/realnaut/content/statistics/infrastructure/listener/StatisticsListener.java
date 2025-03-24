package com.realnaut.content.statistics.infrastructure.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnaut.content.statistics.application.CreateStatisticsUseCase;
import com.realnaut.content.statistics.application.mapper.StatisticsMapper;
import com.realnaut.content.statistics.infrastructure.repository.dto.StatisticsInputDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StatisticsListener {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CreateStatisticsUseCase createStatisticsUseCase;

    @Autowired
    StatisticsMapper mapper;

    @KafkaListener(id = "statistics-consumer-1",
                   topics = "${consumers.configuration.statistics-consumer-1.topic}",
                   groupId = "${consumers.configuration.statistics-consumer-1.groupId}",
                   containerFactory = "${consumers.configuration.statistics-consumer-1.containerFactory}")
    public void listen(String message, Acknowledgment ack) throws JsonProcessingException {

        log.info("Received message {}", message);
        StatisticsInputDto inputDto = null;
        try {
            inputDto = objectMapper.readValue(message, StatisticsInputDto.class);
        } catch (Exception e){
            log.info(e.getMessage());
        }

        ack.acknowledge();

        createStatisticsUseCase.create(mapper.inputToDomain(inputDto));
    }

}
