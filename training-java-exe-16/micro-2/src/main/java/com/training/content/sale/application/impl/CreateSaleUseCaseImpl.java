package com.training.content.sale.application.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.content.sale.application.CreateSaleUseCase;
import com.training.content.sale.application.GetSaleUseCase;
import com.training.content.statistics.application.StatisticsPublisherUseCase;
import com.training.content.sale.domain.entity.Sale;
import com.training.content.sale.domain.repository.CreateSaleRepository;
import com.training.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@AllArgsConstructor
@Service
public class CreateSaleUseCaseImpl implements CreateSaleUseCase {

    private final CreateSaleRepository repo;

    private final StatisticsPublisherUseCase publisherUserCase;

    private final GetSaleUseCase getSaleUseCase;


    @Override
    public Sale create(Sale sale) throws ExecutionException, JsonProcessingException, InterruptedException {
        Sale saleCreated = repo.create(sale);

        StatisticsOutputDto statisticsOutputDto = getSaleUseCase.getProductStatistics(saleCreated.getProductId());

        publisherUserCase.sendStatisticsMessage(statisticsOutputDto);

        return saleCreated;

    }
}
