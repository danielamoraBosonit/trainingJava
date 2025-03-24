package com.training.content.product.infrastructure.repository.impl;

import com.training.content.product.application.mapper.ProductMapper;
import com.training.content.product.domain.entity.Product;
import com.training.content.product.domain.repository.GetProductRepository;
import com.training.content.product.infrastructure.repository.jpa.ProductRepositoryJpa;
import com.training.content.product.infrastructure.repository.jpa.entity.ProductJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GetProductRepositoryImpl implements GetProductRepository {

    private final ProductRepositoryJpa repoJpa;

    private final ProductMapper mapper;

    @Override
    public Product getById(Long id) {

        ProductJpa productJpa = repoJpa.getReferenceById(id);

        return mapper.jpaToDomain(productJpa);
    }

    @Override
    public List<Product> getAll(String packaging, Integer unitsBox) {
        List<ProductJpa> productJpaList = repoJpa.findAllByPackagingAndUnitsBox(packaging, unitsBox);

        return productJpaList.stream()
                .map(mapper::jpaToDomain)
                .collect(Collectors.toList());
    }
}
