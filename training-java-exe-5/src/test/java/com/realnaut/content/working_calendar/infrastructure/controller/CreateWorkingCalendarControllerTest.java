package com.realnaut.content.working_calendar.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnaut.TestData;
import com.realnaut.content.working_calendar.application.CreateWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
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
class CreateWorkingCalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateWorkingCalendarUseCase useCase;

    @Autowired
    private WorkingCalendarMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        //Given
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("startDate", "2022-01-01 10:00:00");
        jsonBody.put("endDate", "2022-01-10 10:00:00");
        jsonBody.put("cityId", 2);
        jsonBody.put("employeeId", 3);
        jsonBody.put("priority", 3);

        WorkingCalendar expectedWorkingCalendar = TestData.getWorkingCalendar1();

        when(useCase.create(any())).thenReturn(expectedWorkingCalendar);

        //When
        String responseJson = mockMvc.perform(post("/api/working-calendar/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        WorkingCalendarOutputDto result = objectMapper.readValue(responseJson, WorkingCalendarOutputDto.class);

        ArgumentCaptor<WorkingCalendar> captor = ArgumentCaptor.forClass(WorkingCalendar.class);
        verify(useCase).create(captor.capture());
        WorkingCalendar capturedWorkingCalendar = captor.getValue();

        //Then
        assertEquals(capturedWorkingCalendar.getEmployeeId(), 3);
        assertEquals(capturedWorkingCalendar.getCityId(), 2);
        assertEquals(capturedWorkingCalendar.getPriority(), 3);
        assertEquals(capturedWorkingCalendar.getStartDate(), LocalDateTime.of(2022, 1, 1, 10, 0, 0));
        assertEquals(capturedWorkingCalendar.getEndDate(), LocalDateTime.of(2022, 1, 10, 10, 0, 0));

        assertEquals(expectedWorkingCalendar.getId(), result.getId());
        assertEquals(expectedWorkingCalendar.getEmployeeId(), result.getEmployeeId());
        assertEquals(expectedWorkingCalendar.getCityId(), result.getCityId());
        assertEquals(expectedWorkingCalendar.getPriority(), result.getPriority());
        assertEquals(expectedWorkingCalendar.getStartDate(), result.getStartDate());
        assertEquals(expectedWorkingCalendar.getEndDate(), result.getEndDate());
    }
}