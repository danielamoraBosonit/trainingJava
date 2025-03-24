package com.training.content.product_price.domain.repository;

import com.training.content.product_price.domain.entity.ProductPrice;


public interface CreateProductPriceRepository {
    ProductPrice create(ProductPrice productPrice);
}
