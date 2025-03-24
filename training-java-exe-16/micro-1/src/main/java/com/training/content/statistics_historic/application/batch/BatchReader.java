package com.training.content.statistics_historic.application.batch;

import com.training.content.statistics.application.GetStatisticsUseCase;
import com.training.content.statistics.domain.entity.Statistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

@Slf4j
public class BatchReader implements ItemReader<Statistics> {

    @Autowired
    private GetStatisticsUseCase getStatisticsUseCase;

    private Iterator<Statistics> statisticsIterator;

    @BeforeStep
    public void before(StepExecution stepExecution){
        log.info("Reading from statistics");
        statisticsIterator = getStatisticsUseCase.getAll().iterator();
    }

    @Override
    public Statistics read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (statisticsIterator != null && statisticsIterator.hasNext()){
            return statisticsIterator.next();
        } else {
            return null;
        }
    }
}
