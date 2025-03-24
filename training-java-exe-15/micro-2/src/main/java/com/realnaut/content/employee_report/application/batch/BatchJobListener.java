package com.realnaut.content.employee_report.application.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;


@Slf4j
public class BatchJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Before Start Employee Report Job");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("After Finish Employee Report Job");
    }
}
