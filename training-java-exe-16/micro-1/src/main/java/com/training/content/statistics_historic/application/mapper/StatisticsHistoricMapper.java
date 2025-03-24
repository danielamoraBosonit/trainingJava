package com.training.content.statistics_historic.application.mapper;

import com.training.content.statistics_historic.domain.entity.StatisticsHistoric;
import com.training.content.statistics_historic.infrastructure.repository.jpa.entity.StatisticsHistoricJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StatisticsHistoricMapper {

    StatisticsHistoric jpaToDomain(StatisticsHistoricJpa statisticsHistoricJpa);

    StatisticsHistoricJpa domainToJpa(StatisticsHistoric statisticsHistoric);


}
