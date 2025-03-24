package com.training.content.product_price.application.impl;

import com.training.content.product_price.application.CreateProductPriceUseCase;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.CreateProductPriceRepository;
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
