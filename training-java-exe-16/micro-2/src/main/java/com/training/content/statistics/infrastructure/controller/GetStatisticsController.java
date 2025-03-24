package com.training.content.statistics.infrastructure.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.content.sale.application.GetSaleUseCase;
import com.training.content.statistics.application.impl.StatisticsPublisherUserCaseImpl;
import com.training.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/statistics")
public class GetStatisticsController {

    private final GetSaleUseCase useCase;

    private final StatisticsPublisherUserCaseImpl publisher;



    @GetMapping("/{productId}")
    public StatisticsOutputDto getProductStatistics(@PathVariable Integer productId) throws JsonProcessingException, ExecutionException, InterruptedException {

        StatisticsOutputDto statistics = useCase.getProductStatistics(productId);

        publisher.sendStatisticsMessage(statistics);

        return statistics;
    }


}
