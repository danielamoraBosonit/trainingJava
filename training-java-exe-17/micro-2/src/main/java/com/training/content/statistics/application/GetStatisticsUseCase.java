package com.training.content.statistics.application;

import com.training.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;


public interface GetStatisticsUseCase {

    StatisticsOutputDto getProductStatistics(Integer productId);
}
