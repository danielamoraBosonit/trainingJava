package com.training.content.product_price.application.impl;

import com.training.content.product_price.application.DeleteProductPriceUseCase;
import com.training.content.product_price.application.GetProductPriceUseCase;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.DeleteProductPriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class DeleteProductPriceUseCaseImpl implements DeleteProductPriceUseCase {

    private final DeleteProductPriceRepository repo;

    private final GetProductPriceUseCase getProductPriceUseCase;

    @Override
    public void delete(Long id) {
        ProductPrice productPrice = getProductPriceUseCase.getById(id);
        repo.delete(productPrice);
    }


}
