package com.realnaut.config.batch;


import com.realnaut.content.employee_report.application.batch.BatchJobListener;
import com.realnaut.content.employee_report.application.batch.BatchProcessor;
import com.realnaut.content.employee_report.application.batch.BatchReader;
import com.realnaut.content.employee_report.application.batch.BatchWriter;
import com.realnaut.content.employee_report.domain.entity.EmployeeReport;
import com.realnaut.content.time_clock.domain.entity.TimeClock;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JobStatisticBatchConfiguration {

    @Bean
    BatchReader reader(){
        return new BatchReader();
    }

    @Bean
    BatchProcessor processor(){
        return new BatchProcessor();
    }

    @Bean
    BatchWriter writer(){
        return new BatchWriter();
    }

    @Bean
    BatchJobListener jobExecutionListener(){
        return new BatchJobListener();
    }



    @Bean
    public Job statisticsHistoricJob(Step step1, BatchJobListener jobExecutionListener, JobRepository jobRepository){

        return new JobBuilder("employeeReportJob", jobRepository)
                .listener(jobExecutionListener)
                .flow(step1)
                .end()
                .build();
    }


    @Bean
    public Step step1(JobRepository jobRepository,
                      BatchReader reader,
                      BatchWriter writer,
                      BatchProcessor processor,
                      PlatformTransactionManager transactionManager){
        return new StepBuilder("step1", jobRepository)
                .<TimeClock, EmployeeReport>chunk(50, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }



}
