package com.training.content.product_price.application.impl;

import com.training.TestData;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.GetProductPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetProductPriceUseCaseImplTest {

    @Autowired
    private GetProductPriceUseCaseImpl service;

    @MockBean
    private GetProductPriceRepository repo;

    @Test
    void getById() {
        //Given
        ProductPrice productPrice = TestData.getProductPrice1();

        when(repo.getById(anyLong())).thenReturn(productPrice);

        //When
        ProductPrice result = service.getById(1L);

        //Then
        assertEquals(productPrice, result);

    }

    @Test
    void getAll() {
        //Given
        List<ProductPrice> productPriceList = new ArrayList<>();
        productPriceList.add(TestData.getProductPrice1());
        productPriceList.add(TestData.getProductPrice2());
        productPriceList.add(TestData.getProductPrice3());
        productPriceList.add(TestData.getProductPrice4());

        when(repo.getAll(any())).thenReturn(productPriceList);

        //When
        List<ProductPrice> result = service.getAll(any());

        //Then
        assertEquals(productPriceList.size(), result.size());

    }
}