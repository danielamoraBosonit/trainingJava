package com.training.content.statistics_historic.application.batch;

import com.training.content.statistics.domain.entity.Statistics;
import com.training.content.statistics_historic.domain.entity.StatisticsHistoric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;

@Slf4j
public class BatchProcessor implements ItemProcessor<Statistics, StatisticsHistoric> {
    @Override
    public StatisticsHistoric process(Statistics item) throws Exception {
        log.info("Processing item id={}", item.getProductId().getId());

        StatisticsHistoric statisticsHistoric = StatisticsHistoric.builder()
                .productId(item.getProductId().getId().intValue())
                .totalUnits(item.getTotalUnits())
                .totalAmount(item.getTotalAmount())
                .statisticsDate(LocalDateTime.now())
                .build();

        return statisticsHistoric;
    }
}
