package com.realnaut.content.sale.application;

import com.realnaut.content.sale.domain.entity.Sale;
import com.realnaut.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;

import java.util.List;

public interface GetSaleUseCase {

    List<Sale> getAllByProduct(Integer productId);

    StatisticsOutputDto getProductStatistics(Integer productId);
}
