package com.training.content.product_price.application;

import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceFilters;

import java.util.List;

public interface GetProductPriceUseCase {

    ProductPrice getById(Long id);

    List<ProductPrice> getAll(ProductPriceFilters filters);

}
