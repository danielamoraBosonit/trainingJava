package com.realnaut.content.time_clock.infrastructure.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnaut.content.time_clock.application.ProcessTimeClockMsgUseCase;
import com.realnaut.content.time_clock.application.mapper.TimeClockMapper;
import com.realnaut.content.time_clock.infrastructure.controller.dto.TimeClockInputDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TimeClockListener {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProcessTimeClockMsgUseCase processTimeClockMsgUseCase;

    @Autowired
    TimeClockMapper mapper;

    @KafkaListener(id = "clients-consumer-1",
                   topics = "${consumers.configuration.clients-consumer-1.topic}",
                   groupId = "${consumers.configuration.clients-consumer-1.groupId}",
                   containerFactory = "${consumers.configuration.clients-consumer-1.containerFactory}")
    public void listen(String message, Acknowledgment ack) throws JsonProcessingException {

        log.info("Received message {}", message);
        TimeClockInputDto inputDto = null;
        try {
            inputDto = objectMapper.readValue(message, TimeClockInputDto.class);
        } catch (Exception e){
            log.info(e.getMessage());
        }

        ack.acknowledge();

        processTimeClockMsgUseCase.processTimeClock(mapper.inputToDomain(inputDto));
    }

}
