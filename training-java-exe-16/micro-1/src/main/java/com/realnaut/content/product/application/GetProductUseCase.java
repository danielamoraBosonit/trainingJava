package com.realnaut.content.product.application;

import com.realnaut.content.product.domain.entity.Product;
import com.realnaut.content.product.infrastructure.controller.dto.ProductOutputVO;

import java.util.List;

public interface GetProductUseCase {

    Product getById(Long id);

    List<Product> getAll();

    List<Product> getAll(String packaging, Integer unitsBox);

    List<ProductOutputVO> getProductsStatistics(List<Integer> productIds);
}
