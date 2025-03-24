package com.realnaut.content.employee_report.application.batch;


import com.realnaut.content.time_clock.application.GetTimeClockUseCase;
import com.realnaut.content.time_clock.domain.entity.TimeClock;
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
public class BatchReader implements ItemReader<TimeClock> {

    @Autowired
    private GetTimeClockUseCase getTimeClockUseCase;

    private Iterator<TimeClock> timeClockIterator;

    @BeforeStep
    public void before(StepExecution stepExecution){
        log.info("Reading from statistics");
        timeClockIterator = getTimeClockUseCase.getAll().iterator();
    }

    @Override
    public TimeClock read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (timeClockIterator != null && timeClockIterator.hasNext()){
            return timeClockIterator.next();
        } else {
            return null;
        }
    }
}
