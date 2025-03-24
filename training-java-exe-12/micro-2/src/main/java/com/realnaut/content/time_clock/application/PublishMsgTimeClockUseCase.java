package com.realnaut.content.time_clock.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.realnaut.content.time_clock.infrastructure.controller.dto.TimeClockOutputDto;

import java.util.concurrent.ExecutionException;


public interface PublishMsgTimeClockUseCase {

    void sendTimeClockMessage(TimeClockOutputDto timeClock) throws JsonProcessingException, ExecutionException, InterruptedException;

}
