package com.training.content.product_price.domain.repository;

import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceFilters;

import java.util.List;

public interface GetProductPriceRepository {
    ProductPrice getById(Long id);

    List<ProductPrice> getAll(ProductPriceFilters filters);
}
