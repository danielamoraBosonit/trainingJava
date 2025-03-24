package com.training.content.product.domain.repository;

import com.training.content.product.domain.entity.Product;

import java.util.List;

public interface GetProductRepository {
    Product getById(Long id);

    List<Product> getAll(String packaging, Integer unitsBox);

    List<Product> getAll();

}
