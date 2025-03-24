package com.realnaut.content.statistics.domain.repository;

import com.realnaut.content.statistics.domain.entity.Statistics;


public interface CreateStatisticsRepository {
    Statistics create(Statistics statistics);
}
