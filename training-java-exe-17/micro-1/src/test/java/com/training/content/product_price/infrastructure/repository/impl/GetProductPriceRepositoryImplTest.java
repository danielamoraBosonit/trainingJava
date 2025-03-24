package com.training.content.product_price.infrastructure.repository.impl;

import com.training.TestData;
import com.training.content.product_price.application.mapper.ProductPriceMapper;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.infrastructure.repository.jpa.ProductPriceRepositoryJpa;
import com.training.content.product_price.infrastructure.repository.jpa.entity.ProductPriceJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetProductPriceRepositoryImplTest {

    @Autowired
    private GetProductPriceRepositoryImpl service;

    @MockBean
    private ProductPriceRepositoryJpa repoJpa;

    @Autowired
    private ProductPriceMapper mapper;

    @Test
    void getById() {
        //Given
        ProductPriceJpa productPriceJpa = TestData.getProductPriceJpa1();

        when(repoJpa.getReferenceById(anyLong())).thenReturn(productPriceJpa);

        //When
        ProductPrice result = service.getById(1L);

        //Then
        assertEquals(productPriceJpa.getId(), result.getId());
        assertEquals(productPriceJpa.getBrandId(), result.getBrandId());
        assertEquals(productPriceJpa.getStartDate(), result.getStartDate());
        assertEquals(productPriceJpa.getEndDate(), result.getEndDate());
        assertEquals(productPriceJpa.getPriceList(), result.getPriceList());
        assertEquals(productPriceJpa.getProductId().getId(), result.getProductId().getId());
        assertEquals(productPriceJpa.getPriority(), result.getPriority());
        assertEquals(productPriceJpa.getPrice(), result.getPrice());
        assertEquals(productPriceJpa.getCurr(), result.getCurrency());
    }

    @Test
    void getAll() {
        //Given
        List<ProductPriceJpa> productPriceJpaList = new ArrayList<>();
        productPriceJpaList.add(TestData.getProductPriceJpa1());
        productPriceJpaList.add(TestData.getProductPriceJpa2());
        productPriceJpaList.add(TestData.getProductPriceJpa3());
        productPriceJpaList.add(TestData.getProductPriceJpa4());

        when(repoJpa.findAll(any(Specification.class))).thenReturn(productPriceJpaList);

        //When
        List<ProductPrice> result = service.getAll(any());

        //Then
        assertEquals(productPriceJpaList.size(), result.size());

    }
}