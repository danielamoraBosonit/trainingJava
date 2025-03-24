package com.training.content.product_price.infrastructure.controller;

import com.training.content.product_price.application.DeleteProductPriceUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeleteProductPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeleteProductPriceUseCase useCase;


    @Test
    void delete() throws Exception {
        //Given

        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/product-price/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Then
        verify(useCase, times(1)).delete(1L);
    }
}