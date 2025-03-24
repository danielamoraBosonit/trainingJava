package com.realnaut.content.statistics_historic.application.batch;

import com.realnaut.content.statistics_historic.application.CreateStatisticsHistoricUseCase;
import com.realnaut.content.statistics_historic.domain.entity.StatisticsHistoric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BatchWriter implements ItemWriter<StatisticsHistoric> {

    @Autowired
    private CreateStatisticsHistoricUseCase createStatisticsHistoricUseCase;

    @Override
    public void write(Chunk<? extends StatisticsHistoric> chunk) {
        log.info("Writing");
        List<StatisticsHistoric> statisticsHistoricList = new ArrayList<>();

        for (StatisticsHistoric statisticsHistoric : chunk){
            statisticsHistoricList.add(statisticsHistoric);

        }
        createStatisticsHistoricUseCase.createAll(statisticsHistoricList);
    }
}
