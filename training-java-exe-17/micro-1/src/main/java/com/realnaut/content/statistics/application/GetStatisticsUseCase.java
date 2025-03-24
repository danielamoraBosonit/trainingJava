package com.realnaut.content.statistics.application;

import com.realnaut.content.statistics.domain.entity.Statistics;
import com.realnaut.content.statistics.infrastructure.repository.dto.StatisticsOutputDto;

import java.util.List;


public interface GetStatisticsUseCase {

    StatisticsOutputDto getById(Long id);

    List<Statistics> getAll();

}
