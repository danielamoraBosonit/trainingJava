package com.realnaut.content.product_price.application.impl;

import com.realnaut.content.product_price.application.CreateProductPriceUseCase;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.domain.repository.CreateProductPriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CreateProductPriceUseCaseImpl implements CreateProductPriceUseCase {

    private final CreateProductPriceRepository repo;

    @Override
    public ProductPrice create(ProductPrice productPrice) {

        return repo.create(productPrice);

    }
}
