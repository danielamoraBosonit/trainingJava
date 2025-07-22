package com.training.content.working_calendar.infrastructure.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.content.TestData;
import com.training.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
        List<WorkingCalendar> workingCalendarsExpected = new ArrayList<>();
        workingCalendarsExpected.add(TestData.getWorkingCalendar0());
        workingCalendarsExpected.add(TestData.getWorkingCalendar1());
        workingCalendarsExpected.add(TestData.getWorkingCalendar2());
        workingCalendarsExpected.add(TestData.getWorkingCalendar3());
        workingCalendarsExpected.add(TestData.getWorkingCalendar4());

        when(useCase.getAll(any())).thenReturn(workingCalendarsExpected);

        //When
        String responseJson = mockMvc.perform(get("/api/working-calendar/")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        List<WorkingCalendarOutputDto> output = objectMapper.readValue(responseJson, new TypeReference<>() {});

        //Then
        assertEquals(output.size(), workingCalendarsExpected.size());
    }

    @Test
    void getById() throws Exception {
        //Given
        WorkingCalendar workingCalendarExpected = TestData.getWorkingCalendar0();
        Integer expectedInterval = (int) ChronoUnit.DAYS.between(workingCalendarExpected.getStartDate().toLocalDate(),
                workingCalendarExpected.getEndDate().toLocalDate());

        when(useCase.getById(0)).thenReturn(workingCalendarExpected);

        //When
        String responseJson = mockMvc.perform(get("/api/working-calendar/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        WorkingCalendarOutputDto output = objectMapper.readValue(responseJson, WorkingCalendarOutputDto.class);

        //Then
        assertEquals(workingCalendarExpected.getId(), output.getId());
        assertEquals(workingCalendarExpected.getEmployeeId().getId(), output.getEmployeeId().getId());
        assertEquals(workingCalendarExpected.getCityId(), output.getCityId());
        assertEquals(workingCalendarExpected.getPriority(), output.getPriority());
        assertEquals(workingCalendarExpected.getStartDate(), output.getStartDate());
        assertEquals(workingCalendarExpected.getEndDate(), output.getEndDate());
        assertEquals(expectedInterval, output.getInterval());
    }
}