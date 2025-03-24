package com.realnaut.content.statistics_historic.application;

import com.realnaut.content.statistics_historic.domain.entity.StatisticsHistoric;

import java.util.List;


public interface CreateStatisticsHistoricUseCase {

    StatisticsHistoric create(StatisticsHistoric statisticsHistoric);

    List<StatisticsHistoric> createAll(List<StatisticsHistoric> statisticsHistoricList);

}
