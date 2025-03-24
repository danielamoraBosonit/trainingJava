package com.realnaut.content.product_price.infrastructure.repository.impl;

import com.realnaut.TestData;
import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.infrastructure.repository.impl.UpdateProductPriceRepositoryImpl;
import com.realnaut.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.realnaut.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import com.realnaut.error.CustomException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class UpdateProductPriceRepositoryImplTest {

    @Autowired
    private UpdateProductPriceRepositoryImpl service;

    @MockBean
    private ProductPriceRepositoryJpa repoJpa;

    @Autowired
    private ProductPriceMapper mapper;

    @Test
    void update() throws CustomException {
        //Given
        ProductPrice productPrice = TestData.getProductPrice1();
        ProductPriceJpa productPriceJpa = TestData.getProductPriceJpa1();

        when(repoJpa.findById(anyLong())).thenReturn(Optional.of(productPriceJpa));

        //When
        ProductPrice result = service.update(productPrice);

        //Then
        verify(repoJpa, times(1)).save(any());
    }


    @Test
    void updateWithProductNotFound() {
        //Given
        ProductPrice productPrice = TestData.getProductPrice1();

        when(repoJpa.findById(anyLong())).thenReturn(Optional.empty());

        //When
        assertThrows(CustomException.class, () -> {
            service.update(productPrice);
        });

        //Then
        verify(repoJpa, times(0)).save(any());
    }


}