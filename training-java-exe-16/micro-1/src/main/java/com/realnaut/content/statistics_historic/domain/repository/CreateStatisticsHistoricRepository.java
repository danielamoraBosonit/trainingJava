package com.realnaut.content.statistics_historic.domain.repository;

import com.realnaut.content.statistics_historic.domain.entity.StatisticsHistoric;


public interface CreateStatisticsHistoricRepository {
    StatisticsHistoric create(StatisticsHistoric statisticsHistoric);
}
