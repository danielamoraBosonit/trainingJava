package com.training.content.product_price.domain.repository;

import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.error.CustomException;


public interface UpdateProductPriceRepository {
    ProductPrice update(ProductPrice productPrice) throws CustomException;
}
