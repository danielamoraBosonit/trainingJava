package com.realnaut.content.employee_report.application.batch;

import com.realnaut.content.employee_report.domain.entity.EmployeeReport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BatchWriter implements ItemWriter<EmployeeReport> {

    @Autowired
    private CreateStatisticsHistoricUseCase createStatisticsHistoricUseCase;

    @Override
    public void write(Chunk<? extends EmployeeReport> chunk) {
        log.info("Writing");
        List<EmployeeReport> statisticsHistoricList = new ArrayList<>();

        for (EmployeeReport statisticsHistoric : chunk){
            statisticsHistoricList.add(statisticsHistoric);

        }
        createStatisticsHistoricUseCase.createAll(statisticsHistoricList);
    }
}
