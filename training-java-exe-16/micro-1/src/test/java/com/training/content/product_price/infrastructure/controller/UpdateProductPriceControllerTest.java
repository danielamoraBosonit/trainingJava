package com.training.content.product_price.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.TestData;
import com.training.content.product_price.application.UpdateProductPriceUseCase;
import com.training.content.product_price.application.mapper.ProductPriceMapper;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceOutputDto;
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
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UpdateProductPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpdateProductPriceUseCase useCase;

    @Autowired
    private ProductPriceMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void update() throws Exception {
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

        when(useCase.update(any())).thenReturn(expectedProductPrice);

        //When
        String responseJson = mockMvc.perform(put("/api/product-price/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        ProductPriceOutputDto result = objectMapper.readValue(responseJson, ProductPriceOutputDto.class);

        ArgumentCaptor<ProductPrice> captor = ArgumentCaptor.forClass(ProductPrice.class);
        verify(useCase).update(captor.capture());
        ProductPrice capturedProductPrice = captor.getValue();

        //Then
        assertEquals(capturedProductPrice.getId(), 1L);
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


    @Test
    void patchUpdate() throws Exception {
        //Given
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("brandId", 10);

        ProductPrice expectedProductPrice = TestData.getProductPrice1();

        when(useCase.patchUpdate(any(), any())).thenReturn(expectedProductPrice);

        //When
        String responseJson = mockMvc.perform(patch("/api/product-price/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        ProductPriceOutputDto result = objectMapper.readValue(responseJson, ProductPriceOutputDto.class);

        ArgumentCaptor<Map<String, Object>> captorMap = ArgumentCaptor.forClass(Map.class);
        ArgumentCaptor<Long> captorLong = ArgumentCaptor.forClass(Long.class);

        verify(useCase).patchUpdate(captorLong.capture(), captorMap.capture());

        Map<String, Object> capturedMap = captorMap.getValue();

        assertTrue(capturedMap.containsKey("brandId"));
        assertEquals(10, capturedMap.get("brandId"));

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