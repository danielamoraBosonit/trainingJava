package com.training.content.product_price.application.impl;

import com.training.content.product_price.application.GetProductPriceUseCase;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.GetProductPriceRepository;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceFilters;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetProductPriceUseCaseImpl implements GetProductPriceUseCase {

    private final GetProductPriceRepository repo;


    @Override
    public ProductPrice getById(Long id){

        return repo.getById(id);
    }


    @Override
    public List<ProductPrice> getAll(ProductPriceFilters filters){

        return repo.getAll(filters);
    }


}
