package com.training.config.batch;

import com.training.content.statistics.domain.entity.Statistics;
import com.training.content.statistics_historic.application.batch.BatchJobListener;
import com.training.content.statistics_historic.application.batch.BatchProcessor;
import com.training.content.statistics_historic.application.batch.BatchReader;
import com.training.content.statistics_historic.application.batch.BatchWriter;
import com.training.content.statistics_historic.domain.entity.StatisticsHistoric;
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

        return new JobBuilder("statisticsHistoricJob", jobRepository)
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
                .<Statistics, StatisticsHistoric>chunk(50, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }



}
