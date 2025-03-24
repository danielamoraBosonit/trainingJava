package com.realnaut.content.product_price.application.impl;

import com.realnaut.TestData;
import com.realnaut.content.product_price.application.GetProductPriceUseCase;
import com.realnaut.content.product_price.application.impl.UpdateProductPriceUseCaseImpl;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.domain.repository.UpdateProductPriceRepository;
import com.realnaut.error.CustomException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UpdateProductPriceUseCaseImplTest {

    @Autowired
    private UpdateProductPriceUseCaseImpl service;

    @MockBean
    private UpdateProductPriceRepository repo;

    @MockBean
    private GetProductPriceUseCase getProductPriceUseCase;

    @Test
    void update() throws CustomException {
        //Given
        ProductPrice productPrice = TestData.getProductPrice1();

        when(repo.update(any())).thenReturn(productPrice);

        //When
        ProductPrice result = service.update(new ProductPrice());

        //Then
        assertEquals(productPrice, result);
    }

    @Test
    void patchUpdate() throws CustomException {
        //Given
        Map<String, Object> fields = new HashMap<>();
        fields.put("id", 5L);
        fields.put("productId", 2);
        fields.put("priceList", 3);
        fields.put("brandId", 10);
        fields.put("priority", 5);
        fields.put("price", 25.00);
        fields.put("currency", "USD");
        fields.put("startDate", LocalDateTime.of(2020, 1, 1, 9, 30, 15));
        fields.put("endDate", null); //to set a field as null

        ProductPrice productPrice = TestData.getProductPrice1();
        when(getProductPriceUseCase.getById(anyLong())).thenReturn(productPrice);

        //When
        service.patchUpdate(1L, fields);

        ArgumentCaptor<ProductPrice> captor = ArgumentCaptor.forClass(ProductPrice.class);
        verify(repo).update(captor.capture());
        ProductPrice capturedProductPrice = captor.getValue();

        //Then
        assertEquals(capturedProductPrice.getId(), 1L); //id must no change
        assertEquals(capturedProductPrice.getProductId().getId(), 2);
        assertEquals(capturedProductPrice.getPriceList(), 3);
        assertEquals(capturedProductPrice.getBrandId(), 10);
        assertEquals(capturedProductPrice.getPriority(), 5);
        assertEquals(capturedProductPrice.getPrice(), 25.00);
        assertEquals(capturedProductPrice.getCurrency(), "USD");
        assertEquals(capturedProductPrice.getStartDate(), LocalDateTime.of(2020, 1, 1, 9, 30, 15));
        assertNull(capturedProductPrice.getEndDate());

    }
}