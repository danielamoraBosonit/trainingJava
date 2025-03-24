package com.training.content.product_price.application.impl;

import com.training.TestData;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.CreateProductPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreateProductPriceUseCaseImplTest {

    @Autowired
    private CreateProductPriceUseCaseImpl service;

    @MockBean
    private CreateProductPriceRepository repo;

    @Test
    void create() {
        //Given
        ProductPrice productPrice = TestData.getProductPrice1();

        when(repo.create(any())).thenReturn(productPrice);

        //When
        ProductPrice result = service.create(new ProductPrice());

        //Then
        assertEquals(productPrice, result);

    }
}