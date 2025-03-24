package com.realnaut.content.product_price.application;

import com.realnaut.content.product_price.domain.entity.ProductPrice;


public interface CreateProductPriceUseCase {

    ProductPrice create(ProductPrice productPrice);

}
