package com.training.content.employee_report.application.batch;


import com.training.content.employee_report.domain.entity.EmployeeReport;
import com.training.content.time_clock.domain.entity.TimeClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;

@Slf4j
public class BatchProcessor implements ItemProcessor<TimeClock, EmployeeReport> {
    @Override
    public EmployeeReport process(TimeClock item) throws Exception {
        log.info("Processing item id={}", item.getProductId().getId());

        EmployeeReport statisticsHistoric = EmployeeReport.builder()
                .productId(item.getProductId().getId().intValue())
                .totalUnits(item.getTotalUnits())
                .totalAmount(item.getTotalAmount())
                .statisticsDate(LocalDateTime.now())
                .build();

        return statisticsHistoric;
    }
}
