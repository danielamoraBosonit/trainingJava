package com.training.content.statistics.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;

import java.util.concurrent.ExecutionException;


public interface StatisticsPublisherUseCase {

    void sendStatisticsMessage(StatisticsOutputDto statistics) throws JsonProcessingException, ExecutionException, InterruptedException;

}
