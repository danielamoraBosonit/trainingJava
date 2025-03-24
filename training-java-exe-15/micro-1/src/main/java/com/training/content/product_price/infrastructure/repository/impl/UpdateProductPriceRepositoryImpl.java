package com.training.content.product_price.infrastructure.repository.impl;

import com.training.content.product_price.application.mapper.ProductPriceMapper;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.UpdateProductPriceRepository;
import com.training.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.training.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import com.training.error.CustomErrorType;
import com.training.error.CustomException;
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
