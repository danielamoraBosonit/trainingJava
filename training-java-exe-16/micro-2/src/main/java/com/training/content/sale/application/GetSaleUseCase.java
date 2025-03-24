package com.training.content.sale.application;

import com.training.content.sale.domain.entity.Sale;
import com.training.content.statistics.infrastructure.controller.dto.StatisticsOutputDto;

import java.util.List;

public interface GetSaleUseCase {

    List<Sale> getAllByProduct(Integer productId);

    StatisticsOutputDto getProductStatistics(Integer productId);
}
