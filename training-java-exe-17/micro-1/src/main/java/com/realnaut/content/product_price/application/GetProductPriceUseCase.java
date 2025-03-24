package com.realnaut.content.product_price.application;

import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.infrastructure.controller.dto.ProductPriceFilters;

import java.util.List;

public interface GetProductPriceUseCase {

    ProductPrice getById(Long id);

    List<ProductPrice> getAll(ProductPriceFilters filters);

}
