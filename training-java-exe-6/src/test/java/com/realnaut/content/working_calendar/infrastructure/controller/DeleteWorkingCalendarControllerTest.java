package com.realnaut.content.working_calendar.infrastructure.controller;

import com.realnaut.content.working_calendar.application.DeleteWorkingCalendarUseCase;
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
class DeleteWorkingCalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeleteWorkingCalendarUseCase useCase;


    @Test
    void delete() throws Exception {
        //Given

        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/working-calendar/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Then
        verify(useCase, times(1)).delete(1);
    }
}