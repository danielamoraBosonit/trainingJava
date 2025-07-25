package com.training.content.product_price.application;

import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.error.CustomException;

import java.util.Map;


public interface UpdateProductPriceUseCase {

    ProductPrice update(ProductPrice productPrice) throws CustomException;

    ProductPrice patchUpdate(Long id, Map<String,Object> fields) throws CustomException;

}
