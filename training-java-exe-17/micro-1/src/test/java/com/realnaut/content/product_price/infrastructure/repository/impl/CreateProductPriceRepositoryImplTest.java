package com.realnaut.content.product_price.infrastructure.repository.impl;

import com.realnaut.TestData;
import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.infrastructure.repository.impl.CreateProductPriceRepositoryImpl;
import com.realnaut.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CreateProductPriceRepositoryImplTest {

    @Autowired
    private CreateProductPriceRepositoryImpl service;

    @MockBean
    private ProductPriceRepositoryJpa repoJpa;

    @Autowired
    private ProductPriceMapper mapper;

    @Test
    void create() {
        //Given
        ProductPrice productPrice = TestData.getProductPrice0();

        //When
        ProductPrice result = service.create(productPrice);

        //Then
        verify(repoJpa, times(1)).save(any());
    }
}