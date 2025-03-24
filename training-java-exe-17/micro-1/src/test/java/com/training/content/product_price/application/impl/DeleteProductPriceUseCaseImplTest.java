package com.training.content.product_price.application.impl;

import com.training.TestData;
import com.training.content.product_price.application.GetProductPriceUseCase;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.domain.repository.DeleteProductPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class DeleteProductPriceUseCaseImplTest {

    @Autowired
    private DeleteProductPriceUseCaseImpl service;

    @MockBean
    private DeleteProductPriceRepository repo;

    @MockBean
    private GetProductPriceUseCase getProductPriceUseCase;


    @Test
    void delete() {
        //Given
        ProductPrice productPrice = TestData.getProductPrice1();

        when(getProductPriceUseCase.getById(anyLong())).thenReturn(productPrice);

        //When
        service.delete(1L);

        //Then
        verify(repo, times(1)).delete(any());
    }
}