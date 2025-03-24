package com.training.content.working_calendar.application.impl;

import com.training.TestData;
import com.training.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.UpdateWorkingCalendarRepository;
import com.training.error.CustomException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UpdateWorkingCalendarUseCaseImplTest {

    @Autowired
    private UpdateWorkingCalendarUseCaseImpl service;

    @MockBean
    private UpdateWorkingCalendarRepository repo;

    @MockBean
    private GetWorkingCalendarUseCase getWorkingCalendarUseCase;

    @Test
    void update() throws CustomException {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar1();

        when(repo.update(any())).thenReturn(workingCalendar);

        //When
        WorkingCalendar result = service.update(new WorkingCalendar());

        //Then
        assertEquals(workingCalendar, result);
    }

    @Test
    void patchUpdate() throws CustomException {
        //Given
        Map<String, Object> fields = new HashMap<>();
        fields.put("id", 5);
        fields.put("employeeId", 1);
        fields.put("cityId", 2);
        fields.put("priority", 5);
        fields.put("startDate", LocalDateTime.of(2020, 1, 1, 9, 30, 15));
        fields.put("endDate", null); //to set a field as null

        WorkingCalendar workingCalendar = TestData.getWorkingCalendar1();
        when(getWorkingCalendarUseCase.getById(anyInt())).thenReturn(workingCalendar);

        //When
        service.patchUpdate(1, fields);

        ArgumentCaptor<WorkingCalendar> captor = ArgumentCaptor.forClass(WorkingCalendar.class);
        verify(repo).update(captor.capture());
        WorkingCalendar capturedWorkingCalendar = captor.getValue();

        //Then
        assertEquals(capturedWorkingCalendar.getId(), 1); //id must no change
        assertEquals(capturedWorkingCalendar.getEmployeeId().getId(), 1);
        assertEquals(capturedWorkingCalendar.getCityId(), 2);
        assertEquals(capturedWorkingCalendar.getPriority(), 5);
        assertEquals(capturedWorkingCalendar.getStartDate(), LocalDateTime.of(2020, 1, 1, 9, 30, 15));
        assertNull(capturedWorkingCalendar.getEndDate());

    }
}