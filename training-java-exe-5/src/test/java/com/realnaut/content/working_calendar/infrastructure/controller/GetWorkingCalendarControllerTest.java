package com.realnaut.content.working_calendar.infrastructure.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnaut.TestData;
import com.realnaut.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class GetWorkingCalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetWorkingCalendarUseCase useCase;

    @Autowired
    private WorkingCalendarMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAll() throws Exception {
        //Given
        List<WorkingCalendar> workingCalendarList = new ArrayList<>();
        workingCalendarList.add(TestData.getWorkingCalendar1());
        workingCalendarList.add(TestData.getWorkingCalendar2());
        workingCalendarList.add(TestData.getWorkingCalendar3());
        workingCalendarList.add(TestData.getWorkingCalendar4());

        when(useCase.getAll()).thenReturn(workingCalendarList);

        //When
        String responseJson = mockMvc.perform(get("/api/working-calendar/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        List<WorkingCalendarOutputDto> result = objectMapper.readValue(responseJson, new TypeReference<>() {});

        //Then
        assertEquals(workingCalendarList.size(), result.size());

    }

    @Test
    void getById() throws Exception {
        //Given
        WorkingCalendar expectedWorkingCalendar = TestData.getWorkingCalendar1();
        Integer expectedInterval = (int) ChronoUnit.DAYS.between(expectedWorkingCalendar.getStartDate().toLocalDate(),
                                                                 expectedWorkingCalendar.getEndDate().toLocalDate());

        when(useCase.getById(1)).thenReturn(expectedWorkingCalendar);

        //When
        String responseJson = mockMvc.perform(get("/api/working-calendar/1")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        WorkingCalendarOutputDto result = objectMapper.readValue(responseJson, WorkingCalendarOutputDto.class);

        //Then
        assertEquals(expectedWorkingCalendar.getId(), result.getId());
        assertEquals(expectedWorkingCalendar.getStartDate(), result.getStartDate());
        assertEquals(expectedWorkingCalendar.getEndDate(), result.getEndDate());
        assertEquals(expectedWorkingCalendar.getEmployeeId(), result.getEmployeeId());
        assertEquals(expectedWorkingCalendar.getCityId(), result.getCityId());
        assertEquals(expectedWorkingCalendar.getPriority(), result.getPriority());
        assertEquals(expectedInterval, result.getInterval());

    }
}