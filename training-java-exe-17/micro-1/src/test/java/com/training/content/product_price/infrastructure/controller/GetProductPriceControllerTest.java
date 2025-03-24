package com.training.content.product_price.infrastructure.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.TestData;
import com.training.content.product_price.application.GetProductPriceUseCase;
import com.training.content.product_price.application.mapper.ProductPriceMapper;
import com.training.content.product_price.domain.entity.ProductPrice;
import com.training.content.product_price.infrastructure.controller.dto.ProductPriceOutputDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GetProductPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProductPriceUseCase useCase;

    @Autowired
    private ProductPriceMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAll() throws Exception {
        //Given
        List<ProductPrice> productPriceList = new ArrayList<>();
        productPriceList.add(TestData.getProductPrice1());
        productPriceList.add(TestData.getProductPrice2());
        productPriceList.add(TestData.getProductPrice3());
        productPriceList.add(TestData.getProductPrice4());

        when(useCase.getAll(any())).thenReturn(productPriceList);

        //When
        String responseJson = mockMvc.perform(get("/api/product-price/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        List<ProductPriceOutputDto> result = objectMapper.readValue(responseJson, new TypeReference<>() {});

        //Then
        assertEquals(productPriceList.size(), result.size());

    }

    @Test
    void getById() throws Exception {
        //Given
        ProductPrice expectedProductPrice = TestData.getProductPrice1();
        Integer expectedInterval = (int) ChronoUnit.DAYS.between(expectedProductPrice.getStartDate().toLocalDate(),
                                                                 expectedProductPrice.getEndDate().toLocalDate());

        when(useCase.getById(1L)).thenReturn(expectedProductPrice);

        //When
        String responseJson = mockMvc.perform(get("/api/product-price/1")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        ProductPriceOutputDto result = objectMapper.readValue(responseJson, ProductPriceOutputDto.class);

        //Then
        assertEquals(expectedProductPrice.getId(), result.getId());
        assertEquals(expectedProductPrice.getBrandId(), result.getBrandId());
        assertEquals(expectedProductPrice.getStartDate(), result.getStartDate());
        assertEquals(expectedProductPrice.getEndDate(), result.getEndDate());
        assertEquals(expectedProductPrice.getPriceList(), result.getPriceList());
        assertEquals(expectedProductPrice.getProductId().getId(), result.getProductId().getId());
        assertEquals(expectedProductPrice.getPriority(), result.getPriority());
        assertEquals(expectedProductPrice.getPrice(), result.getPrice());
        assertEquals(expectedProductPrice.getCurrency(), result.getCurrency());
        assertEquals(expectedInterval, result.getInterval());

    }
}