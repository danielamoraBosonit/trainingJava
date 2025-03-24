package com.realnaut.content.product_price.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnaut.TestData;
import com.realnaut.content.product_price.application.CreateProductPriceUseCase;
import com.realnaut.content.product_price.application.mapper.ProductPriceMapper;
import com.realnaut.content.product_price.domain.entity.ProductPrice;
import com.realnaut.content.product_price.infrastructure.controller.dto.ProductPriceOutputDto;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreateProductPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateProductPriceUseCase useCase;

    @Autowired
    private ProductPriceMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        //Given
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("brandId", 1);
        jsonBody.put("startDate", "2022-01-01 10:00:00");
        jsonBody.put("endDate", "2022-01-10 10:00:00");
        jsonBody.put("priceList", 5);
        jsonBody.put("productId", 3214);
        jsonBody.put("priority", 3);
        jsonBody.put("price", 21.12);
        jsonBody.put("currency", "EUR");

        ProductPrice expectedProductPrice = TestData.getProductPrice1();

        when(useCase.create(any())).thenReturn(expectedProductPrice);

        //When
        String responseJson = mockMvc.perform(post("/api/product-price/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        ProductPriceOutputDto result = objectMapper.readValue(responseJson, ProductPriceOutputDto.class);

        ArgumentCaptor<ProductPrice> captor = ArgumentCaptor.forClass(ProductPrice.class);
        verify(useCase).create(captor.capture());
        ProductPrice capturedProductPrice = captor.getValue();

        //Then
        assertEquals(capturedProductPrice.getProductId().getId(), 3214);
        assertEquals(capturedProductPrice.getPriceList(), 5);
        assertEquals(capturedProductPrice.getBrandId(), 1);
        assertEquals(capturedProductPrice.getPriority(), 3);
        assertEquals(capturedProductPrice.getPrice(), 21.12);
        assertEquals(capturedProductPrice.getCurrency(), "EUR");
        assertEquals(capturedProductPrice.getStartDate(), LocalDateTime.of(2022, 1, 1, 10, 0, 0));
        assertEquals(capturedProductPrice.getEndDate(), LocalDateTime.of(2022, 1, 10, 10, 0, 0));

        assertEquals(expectedProductPrice.getId(), result.getId());
        assertEquals(expectedProductPrice.getProductId().getId(), result.getProductId().getId());
        assertEquals(expectedProductPrice.getPriceList(), result.getPriceList());
        assertEquals(expectedProductPrice.getBrandId(), result.getBrandId());
        assertEquals(expectedProductPrice.getPriority(), result.getPriority());
        assertEquals(expectedProductPrice.getPrice(), result.getPrice());
        assertEquals(expectedProductPrice.getCurrency(), result.getCurrency());
        assertEquals(expectedProductPrice.getStartDate(), result.getStartDate());
        assertEquals(expectedProductPrice.getEndDate(), result.getEndDate());
    }
}