package com.realnaut.content.product_price.domain.repository;

import com.realnaut.content.product_price.domain.entity.ProductPrice;


public interface CreateProductPriceRepository {
    ProductPrice create(ProductPrice productPrice);
}
