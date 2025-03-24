package com.realnaut.content.statistics.infrastructure.repository.impl;

import com.realnaut.content.statistics.application.mapper.StatisticsMapper;
import com.realnaut.content.statistics.domain.entity.Statistics;
import com.realnaut.content.statistics.domain.repository.GetStatisticsRepository;
import com.realnaut.content.statistics.infrastructure.repository.jpa.StatisticsRepositoryJpa;
import com.realnaut.content.statistics.infrastructure.repository.jpa.entity.StatisticsJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GetStatisticsRepositoryImpl implements GetStatisticsRepository {

    private final StatisticsRepositoryJpa repoJpa;

    private final StatisticsMapper mapper;

    @Override
    public Statistics getById(Long id) {

        StatisticsJpa statisticsJpa = repoJpa.getReferenceById(id);

        return mapper.jpaToDomain(statisticsJpa);
    }

    @Override
    public Optional<Statistics> findById(Long id) {

        Optional<StatisticsJpa> optionalStatistics = repoJpa.findById(id);

        if (optionalStatistics.isPresent()){
            return Optional.of(mapper.jpaToDomain(optionalStatistics.get()));
        } else {
            return Optional.empty();
        }

    }

    @Override
    public List<Statistics> findAll() {

        List<StatisticsJpa> statisticsJpaList = repoJpa.findAll();

        return statisticsJpaList.stream().map(mapper::jpaToDomain).collect(Collectors.toList());

    }


}
