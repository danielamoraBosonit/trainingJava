package com.realnaut.content.statistics_historic.infrastructure.repository.impl;

import com.realnaut.content.statistics_historic.application.mapper.StatisticsHistoricMapper;
import com.realnaut.content.statistics_historic.domain.entity.StatisticsHistoric;
import com.realnaut.content.statistics_historic.domain.repository.CreateStatisticsHistoricRepository;
import com.realnaut.content.statistics_historic.infrastructure.repository.jpa.StatisticsHistoricRepositoryJpa;
import com.realnaut.content.statistics_historic.infrastructure.repository.jpa.entity.StatisticsHistoricJpa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@AllArgsConstructor
@Slf4j
@Service
public class CreateStatisticsHistoricRepositoryImpl implements CreateStatisticsHistoricRepository {

    private final StatisticsHistoricRepositoryJpa repoJpa;

    private final StatisticsHistoricMapper mapper;

    @Override
    public StatisticsHistoric create(StatisticsHistoric statisticsHistoric) {
        StatisticsHistoricJpa statisticsHistoricJpa = mapper.domainToJpa(statisticsHistoric);

        StatisticsHistoricJpa statisticsHistoricJpaCreated = repoJpa.save(statisticsHistoricJpa);

        log.info("Create statistics historic for product {} ", statisticsHistoric.getProductId());

        return mapper.jpaToDomain(statisticsHistoricJpaCreated);

    }
}
