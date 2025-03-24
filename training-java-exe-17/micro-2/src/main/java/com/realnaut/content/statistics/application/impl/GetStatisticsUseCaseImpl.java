package com.realnaut.content.statistics.application.impl;

import com.realnaut.content.sale.application.GetSaleUseCase;
import com.realnaut.content.sale.domain.entity.Sale;
import com.realnaut.content.sale.domain.repository.GetSaleRepository;
import com.realnaut.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;
import com.realnaut.content.statistics.application.GetStatisticsUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
@AllArgsConstructor
public class GetStatisticsUseCaseImpl implements GetStatisticsUseCase {

    private final GetSaleRepository getSaleRepository;

    private final GetSaleUseCase getSaleUseCase;


    @Override
    public StatisticsOutputDto getProductStatistics(Integer productId) {
        log.info("Generating statistics for product {} ", productId);

        AtomicReference<Integer> totalUnits = new AtomicReference<>(0);
        AtomicReference<Double> totalAmount = new AtomicReference<>(0d);

        List<Sale> saleList = getSaleUseCase.getAllByProduct(productId);

        saleList.stream().forEach( sale -> {
                    totalUnits.updateAndGet(v -> v + sale.getUnits());
                    totalAmount.updateAndGet(v -> v + sale.getUnits() * sale.getUnitPrice());
                }
        );

        return StatisticsOutputDto.builder()
                .productId(productId)
                .totalUnits(totalUnits.get())
                .totalAmount((double) Math.round(totalAmount.get() * 100.00) / 100.00)
                .averagePrice(totalUnits.get() > 0 && totalAmount.get() > 0 ?
                             (double) Math.round(totalAmount.get() / totalUnits.get() * 100.00) / 100.00  :
                              null)
                .build();
    }

}
