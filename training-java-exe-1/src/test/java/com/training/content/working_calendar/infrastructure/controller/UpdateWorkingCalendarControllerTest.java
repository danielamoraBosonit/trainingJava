package com.training.content.working_calendar.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.content.TestData;
import com.training.content.working_calendar.application.UpdateWorkingCalendarUseCase;
import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UpdateWorkingCalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpdateWorkingCalendarUseCase useCase;

    @Autowired
    private WorkingCalendarMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void updateWorkingCalendar() throws Exception {
        //Given
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("startDate", "2022-01-01 10:00:00");
        jsonBody.put("endDate", "2022-01-10 10:00:00");
        jsonBody.put("cityId", 2);
        jsonBody.put("employeeId", 3);
        jsonBody.put("priority", 3);

        WorkingCalendar workingCalendarExpected = TestData.getWorkingCalendar1();

        when(useCase.updateWorkingCalendar(any())).thenReturn(workingCalendarExpected);

        //When
        String responseJson = mockMvc.perform(put("/api/working-calendar/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        WorkingCalendarOutputDto output = objectMapper.readValue(responseJson, WorkingCalendarOutputDto.class);

        ArgumentCaptor<WorkingCalendar> calendarCaptor = ArgumentCaptor.forClass(WorkingCalendar.class);
        verify(useCase).updateWorkingCalendar(calendarCaptor.capture());
        WorkingCalendar capturedWorkingCalendar = calendarCaptor.getValue();

        //Then
        assertEquals(1L, capturedWorkingCalendar.getId());
        assertEquals(3, capturedWorkingCalendar.getEmployeeId().getId());
        assertEquals(2, capturedWorkingCalendar.getCityId());
        assertEquals(3, capturedWorkingCalendar.getPriority());
        assertEquals(LocalDateTime.of(2022, 1, 1, 10, 0, 0), capturedWorkingCalendar.getStartDate());
        assertEquals(LocalDateTime.of(2022, 1, 10, 10, 0, 0), capturedWorkingCalendar.getEndDate());

        assertEquals(workingCalendarExpected.getId(), output.getId());
        assertEquals(workingCalendarExpected.getEmployeeId().getId(), output.getEmployeeId().getId());
        assertEquals(workingCalendarExpected.getCityId(), output.getCityId());
        assertEquals(workingCalendarExpected.getPriority(), output.getPriority());
        assertEquals(workingCalendarExpected.getStartDate(), output.getStartDate());
        assertEquals(workingCalendarExpected.getEndDate(), output.getEndDate());
    }

    @Test
    void patchWorkingCalendar() throws Exception {

        //Given
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("priority", 12);

        WorkingCalendar workingCalendarExpected = TestData.getWorkingCalendar1();

        when(useCase.patchUpdateWorkingCalendar(any(), any())).thenReturn(workingCalendarExpected);

        //When
        String responseJson = mockMvc.perform(patch("/api/working-calendar/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        WorkingCalendarOutputDto output = objectMapper.readValue(responseJson, WorkingCalendarOutputDto.class);

        ArgumentCaptor<Map<String, Object>> captorMap = ArgumentCaptor.forClass(Map.class);
        ArgumentCaptor<Integer> captorInteger = ArgumentCaptor.forClass(Integer.class);
        verify(useCase).patchUpdateWorkingCalendar(captorInteger.capture(), captorMap.capture());

        Map<String, Object> capturedMap = captorMap.getValue();

        //Then
        assertTrue(capturedMap.containsKey("priority"));
        assertEquals(12, capturedMap.get("priority"));

        assertEquals(workingCalendarExpected.getId(), output.getId());
        assertEquals(workingCalendarExpected.getEmployeeId().getId(), output.getEmployeeId().getId());
        assertEquals(workingCalendarExpected.getCityId(), output.getCityId());
        assertEquals(workingCalendarExpected.getPriority(), output.getPriority());
        assertEquals(workingCalendarExpected.getStartDate(), output.getStartDate());
        assertEquals(workingCalendarExpected.getEndDate(), output.getEndDate());
    }
}