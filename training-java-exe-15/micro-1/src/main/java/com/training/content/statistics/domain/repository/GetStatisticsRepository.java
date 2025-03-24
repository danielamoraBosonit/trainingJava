package com.training.content.statistics.domain.repository;

import com.training.content.statistics.domain.entity.Statistics;

import java.util.List;
import java.util.Optional;


public interface GetStatisticsRepository {
    Statistics getById(Long id);

    Optional<Statistics> findById(Long id);

    List<Statistics> findAll();
}
