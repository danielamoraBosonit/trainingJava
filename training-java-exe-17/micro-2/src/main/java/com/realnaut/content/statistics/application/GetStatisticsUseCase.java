package com.realnaut.content.statistics.application;

import com.realnaut.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;


public interface GetStatisticsUseCase {

    StatisticsOutputDto getProductStatistics(Integer productId);
}
