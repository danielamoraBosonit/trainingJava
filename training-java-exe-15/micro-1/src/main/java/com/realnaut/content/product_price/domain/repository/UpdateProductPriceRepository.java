package com.realnaut.content.product_price.domain.repository;

import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.error.CustomException;


public interface UpdateProductPriceRepository {
    ProductPrice update(ProductPrice productPrice) throws CustomException;
}
