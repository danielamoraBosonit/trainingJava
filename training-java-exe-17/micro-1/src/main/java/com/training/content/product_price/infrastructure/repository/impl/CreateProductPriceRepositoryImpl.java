package com.training.content.product_price.infrastructure.repository.impl;

import com.training.content.product_price.application.mapper.ProductPriceMapper;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.CreateProductPriceRepository;
import com.training.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.training.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CreateProductPriceRepositoryImpl implements CreateProductPriceRepository {

    private final ProductPriceRepositoryJpa repoJpa;

    private final ProductPriceMapper mapper;


    @Override
    public ProductPrice create(ProductPrice productPrice) {

        ProductPriceJpa productPriceJpa = mapper.domainToJpa(productPrice);

        ProductPriceJpa productPriceJpaCreated = repoJpa.save(productPriceJpa);

        return mapper.jpaToDomain(productPriceJpaCreated);
    }
}
