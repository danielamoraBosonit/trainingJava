package com.training.content.statistics.application;

import com.training.content.statistics.domain.entity.Statistics;
import com.training.content.statistics.infrastructure.repository.dto.StatisticsOutputDto;

import java.util.List;


public interface GetStatisticsUseCase {

    StatisticsOutputDto getById(Long id);

    List<Statistics> getAll();

}
