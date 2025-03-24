package com.training.content.statistics_historic.domain.repository;

import com.training.content.statistics_historic.domain.entity.StatisticsHistoric;


public interface CreateStatisticsHistoricRepository {
    StatisticsHistoric create(StatisticsHistoric statisticsHistoric);
}
