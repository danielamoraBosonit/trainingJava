package com.training.content.statistics.infrastructure.repository.impl;

import com.training.content.statistics.application.mapper.StatisticsMapper;
import com.training.content.statistics.domain.entity.Statistics;
import com.training.content.statistics.domain.repository.CreateStatisticsRepository;
import com.training.content.statistics.infrastructure.repository.jpa.StatisticsRepositoryJpa;
import com.training.content.statistics.infrastructure.repository.jpa.entity.StatisticsJpa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@AllArgsConstructor
@Slf4j
@Service
public class CreateStatisticsRepositoryImpl implements CreateStatisticsRepository {

    private final StatisticsRepositoryJpa repoJpa;

    private final StatisticsMapper mapper;

    @Override
    public Statistics create(Statistics statistics) {
        StatisticsJpa statisticsJpa = mapper.domainToJpa(statistics);

        statisticsJpa.setId(statistics.getProductId().getId());

        StatisticsJpa statisticsJpaCreated = repoJpa.save(statisticsJpa);

        log.info("Create statistics for product {} ", statistics.getProductId().getId());

        return mapper.jpaToDomain(statisticsJpaCreated);

    }
}
