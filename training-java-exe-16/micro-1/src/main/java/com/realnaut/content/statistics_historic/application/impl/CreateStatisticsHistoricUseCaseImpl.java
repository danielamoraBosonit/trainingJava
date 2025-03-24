package com.realnaut.content.statistics_historic.application.impl;

import com.realnaut.content.statistics_historic.application.CreateStatisticsHistoricUseCase;
import com.realnaut.content.statistics_historic.domain.entity.StatisticsHistoric;
import com.realnaut.content.statistics_historic.domain.repository.CreateStatisticsHistoricRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class CreateStatisticsHistoricUseCaseImpl implements CreateStatisticsHistoricUseCase {

    private final CreateStatisticsHistoricRepository repo;

    @Override
    public StatisticsHistoric create(StatisticsHistoric statisticsHistoric) {
        return repo.create(statisticsHistoric);
    }


    @Override
    public List<StatisticsHistoric> createAll(List<StatisticsHistoric> statisticsHistoricList) {

        List<StatisticsHistoric> statisticsHistoricCreated = new ArrayList<>();

        for (StatisticsHistoric statisticsHistoric : statisticsHistoricList){
            statisticsHistoricCreated.add(create(statisticsHistoric));
        }

        return statisticsHistoricCreated;
    }
}
