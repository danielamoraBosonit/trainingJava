package com.realnaut.content.statistics_historic.infrastructure.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/batch")
public class StatisticsHistoricJobController {

    @Autowired
    private final JobLauncher jobLauncher;

    @Autowired
    private final Job statisticsHistoricJob;


    @GetMapping("/")
    public void startStatisticsJob(){

        try {
            jobLauncher.run(statisticsHistoricJob,
                    new JobParametersBuilder().addLong("uniqueness", System.nanoTime()).toJobParameters());

        } catch (Exception e){
            log.error("Exception launching statistics job {}", e.getMessage());
        }
        log.error("Finish Statistics Job");

    }


}
