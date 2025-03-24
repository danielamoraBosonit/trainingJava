package com.training.content.product_price.infrastructure.repository.impl;

import com.training.content.product_price.application.mapper.ProductPriceMapper;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.DeleteProductPriceRepository;
import com.training.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.training.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
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
