package com.realnaut.content.product_price.infrastructure.repository.impl;

import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.domain.repository.DeleteProductPriceRepository;
import com.realnaut.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.realnaut.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteProductPriceRepositoryImpl implements DeleteProductPriceRepository {

    private final ProductPriceRepositoryJpa repoJpa;

    private final ProductPriceMapper mapper;


    @Override
    public void delete(ProductPrice productPrice) {

        ProductPriceJpa productPriceJpa = mapper.domainToJpa(productPrice);

        repoJpa.delete(productPriceJpa);
    }
}
