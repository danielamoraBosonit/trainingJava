package com.realnaut.content.statistics_historic.application.mapper;

import com.realnaut.content.statistics_historic.domain.entity.StatisticsHistoric;
import com.realnaut.content.statistics_historic.infrastructure.repository.jpa.entity.StatisticsHistoricJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StatisticsHistoricMapper {

    StatisticsHistoric jpaToDomain(StatisticsHistoricJpa statisticsHistoricJpa);

    StatisticsHistoricJpa domainToJpa(StatisticsHistoric statisticsHistoric);


}
