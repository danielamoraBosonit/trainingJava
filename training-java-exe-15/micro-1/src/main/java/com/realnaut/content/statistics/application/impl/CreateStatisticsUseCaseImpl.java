package com.realnaut.content.statistics.application.impl;

import com.realnaut.content.statistics.application.CreateStatisticsUseCase;
import com.realnaut.content.statistics.domain.entity.Statistics;
import com.realnaut.content.statistics.domain.repository.CreateStatisticsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CreateStatisticsUseCaseImpl implements CreateStatisticsUseCase {

    private final CreateStatisticsRepository repo;

    @Override
    public Statistics create(Statistics statistics) {
        return repo.create(statistics);
    }
}
