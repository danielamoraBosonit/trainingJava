package com.realnaut.content.working_calendar.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realnaut.TestData;
import com.realnaut.content.working_calendar.application.UpdateWorkingCalendarUseCase;
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
    void update() throws Exception {
        //Given
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("startDate", "2022-01-01 10:00:00");
        jsonBody.put("endDate", "2022-01-10 10:00:00");
        jsonBody.put("cityId", 2);
        jsonBody.put("employeeId", 1);
        jsonBody.put("priority", 3);
        jsonBody.put("price", 21.12);
        jsonBody.put("currency", "EUR");

        WorkingCalendar expectedWorkingCalendar = TestData.getWorkingCalendar1();

        when(useCase.update(any())).thenReturn(expectedWorkingCalendar);

        //When
        String responseJson = mockMvc.perform(put("/api/working-calendar/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        WorkingCalendarOutputDto result = objectMapper.readValue(responseJson, WorkingCalendarOutputDto.class);

        ArgumentCaptor<WorkingCalendar> captor = ArgumentCaptor.forClass(WorkingCalendar.class);
        verify(useCase).update(captor.capture());
        WorkingCalendar capturedWorkingCalendar = captor.getValue();

        //Then
        assertEquals(capturedWorkingCalendar.getId(), 1L);
        assertEquals(capturedWorkingCalendar.getEmployeeId().getId(), 1);
        assertEquals(capturedWorkingCalendar.getCityId(), 2);
        assertEquals(capturedWorkingCalendar.getPriority(), 3);
        assertEquals(capturedWorkingCalendar.getStartDate(), LocalDateTime.of(2022, 1, 1, 10, 0, 0));
        assertEquals(capturedWorkingCalendar.getEndDate(), LocalDateTime.of(2022, 1, 10, 10, 0, 0));

        assertEquals(expectedWorkingCalendar.getId(), result.getId());
        assertEquals(expectedWorkingCalendar.getEmployeeId().getId(), result.getEmployeeId().getId());
        assertEquals(expectedWorkingCalendar.getCityId(), result.getCityId());
        assertEquals(expectedWorkingCalendar.getPriority(), result.getPriority());
        assertEquals(expectedWorkingCalendar.getStartDate(), result.getStartDate());
        assertEquals(expectedWorkingCalendar.getEndDate(), result.getEndDate());
    }

    @Test
    void patchUpdate() throws Exception {
        //Given
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("priority", 15);

        WorkingCalendar expectedWorkingCalendar = TestData.getWorkingCalendar1();

        when(useCase.patchUpdate(any(), any())).thenReturn(expectedWorkingCalendar);

        //When
        String responseJson = mockMvc.perform(patch("/api/working-calendar/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        WorkingCalendarOutputDto result = objectMapper.readValue(responseJson, WorkingCalendarOutputDto.class);

        ArgumentCaptor<Map<String, Object>> captorMap = ArgumentCaptor.forClass(Map.class);
        ArgumentCaptor<Integer> captorInteger = ArgumentCaptor.forClass(Integer.class);

        verify(useCase).patchUpdate(captorInteger.capture(), captorMap.capture());

        Map<String, Object> capturedMap = captorMap.getValue();

        assertTrue(capturedMap.containsKey("priority"));
        assertEquals(15, capturedMap.get("priority"));

        assertEquals(expectedWorkingCalendar.getId(), result.getId());
        assertEquals(expectedWorkingCalendar.getEmployeeId().getId(), result.getEmployeeId().getId());
        assertEquals(expectedWorkingCalendar.getCityId(), result.getCityId());
        assertEquals(expectedWorkingCalendar.getPriority(), result.getPriority());
        assertEquals(expectedWorkingCalendar.getStartDate(), result.getStartDate());
        assertEquals(expectedWorkingCalendar.getEndDate(), result.getEndDate());
    }
}