package com.realnaut.content.product_price.infrastructure.repository.impl;

import com.realnaut.TestData;
import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.infrastructure.repository.impl.DeleteProductPriceRepositoryImpl;
import com.realnaut.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.realnaut.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DeleteProductPriceRepositoryImplTest {

    @Autowired
    private DeleteProductPriceRepositoryImpl service;

    @MockBean
    private ProductPriceRepositoryJpa repoJpa;

    @Autowired
    private ProductPriceMapper mapper;


    @Test
    void delete() {
        //Given
        ProductPrice productPrice = TestData.getProductPrice1();

        //When
        service.delete(productPrice);

        ArgumentCaptor<ProductPriceJpa> captor = ArgumentCaptor.forClass(ProductPriceJpa.class);
        verify(repoJpa).delete(captor.capture());
        ProductPriceJpa capturedProductPriceJpa = captor.getValue();

        //Then
        verify(repoJpa, times(1)).delete(any(ProductPriceJpa.class));
        assertEquals(capturedProductPriceJpa.getId(), productPrice.getId()); //id must no change
        assertEquals(capturedProductPriceJpa.getProductId().getId(), productPrice.getProductId().getId());
        assertEquals(capturedProductPriceJpa.getPriceList(), productPrice.getPriceList());
        assertEquals(capturedProductPriceJpa.getBrandId(), productPrice.getBrandId());
        assertEquals(capturedProductPriceJpa.getPriority(), productPrice.getPriority());
        assertEquals(capturedProductPriceJpa.getPrice(), productPrice.getPrice());
        assertEquals(capturedProductPriceJpa.getCurr(), productPrice.getCurrency());
        assertEquals(capturedProductPriceJpa.getStartDate(), productPrice.getStartDate());
        assertEquals(capturedProductPriceJpa.getEndDate(), productPrice.getEndDate());
    }
}