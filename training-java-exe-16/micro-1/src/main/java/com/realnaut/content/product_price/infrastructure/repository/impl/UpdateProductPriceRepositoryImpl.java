package com.realnaut.content.product_price.infrastructure.repository.impl;

import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.domain.repository.UpdateProductPriceRepository;
import com.realnaut.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.realnaut.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import com.realnaut.error.CustomErrorType;
import com.realnaut.error.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class UpdateProductPriceRepositoryImpl implements UpdateProductPriceRepository {

    private final ProductPriceRepositoryJpa repoJpa;

    private final ProductPriceMapper mapper;


    @Override
    public ProductPrice update(ProductPrice productPrice) throws CustomException {

        Optional<ProductPriceJpa> optionalProductPriceJpa = repoJpa.findById(productPrice.getId());

        if (optionalProductPriceJpa.isEmpty()){
            throw new CustomException(CustomErrorType.RESOURCE_NOT_FOUND);
        }

        ProductPriceJpa productPriceJpa = mapper.domainToJpa(productPrice);

        ProductPriceJpa productPriceJpaUpdated = repoJpa.save(productPriceJpa);

        return mapper.jpaToDomain(productPriceJpaUpdated);
    }
}
