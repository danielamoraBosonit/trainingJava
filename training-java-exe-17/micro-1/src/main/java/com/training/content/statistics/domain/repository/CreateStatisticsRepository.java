package com.training.content.statistics.domain.repository;

import com.training.content.statistics.domain.entity.Statistics;


public interface CreateStatisticsRepository {
    Statistics create(Statistics statistics);
}
