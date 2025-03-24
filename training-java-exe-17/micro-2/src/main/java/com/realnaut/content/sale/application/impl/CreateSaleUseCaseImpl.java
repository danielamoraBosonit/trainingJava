package com.realnaut.content.sale.application.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.realnaut.content.sale.application.CreateSaleUseCase;
import com.realnaut.content.sale.application.GetSaleUseCase;
import com.realnaut.content.statistics.application.StatisticsPublisherUseCase;
import com.realnaut.content.sale.domain.entity.Sale;
import com.realnaut.content.sale.domain.repository.CreateSaleRepository;
import com.realnaut.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;
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
