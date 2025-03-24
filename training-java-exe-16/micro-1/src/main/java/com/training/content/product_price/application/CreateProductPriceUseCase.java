package com.training.content.product_price.application;

import com.training.content.product_price.domain.entity.ProductPrice;


public interface CreateProductPriceUseCase {

    ProductPrice create(ProductPrice productPrice);

}
