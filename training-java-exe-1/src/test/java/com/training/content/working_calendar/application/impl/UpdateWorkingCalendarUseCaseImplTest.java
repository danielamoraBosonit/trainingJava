package com.training.content.working_calendar.application.impl;

import com.training.content.TestData;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.UpdateWorkingCalendarRepository;
import com.training.error.CustomException;
import org.hibernate.jdbc.Work;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
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
    private GetWorkingCalendarUseCaseImpl getWorkingCalendarUseCase;

    @Test
    void update() throws CustomException {
        //Given
        WorkingCalendar workingCalendarExpected = TestData.getWorkingCalendar1();
        when(repo.updateWorkingCalendar(any())).thenReturn(workingCalendarExpected);

        //When
        WorkingCalendar output = service.updateWorkingCalendar(new WorkingCalendar());

        //Then
        assertEquals(workingCalendarExpected, output);
    }

    @Test
    void patch() throws CustomException {
        //Given

        Map<String, Object> fields = new HashMap<>();
        fields.put("id", 5);
        fields.put("employeeId", 1);
        fields.put("cityId", 2);
        fields.put("priority", 5);
        fields.put("startDate", LocalDateTime.of(2020, 1, 1, 9, 30, 15));
        fields.put("endDate", null); //to set a field as null

        WorkingCalendar workingCalendarExpected = TestData.getWorkingCalendar1();
        when(getWorkingCalendarUseCase.getById(anyInt())).thenReturn(workingCalendarExpected);

        //When
        service.patchUpdateWorkingCalendar(1, fields);

        ArgumentCaptor<WorkingCalendar> captor = ArgumentCaptor.forClass(WorkingCalendar.class);
        verify(repo).updateWorkingCalendar(captor.capture());
        WorkingCalendar capturedWorkingCalendar = captor.getValue();

        //Then
        assertEquals(1L, capturedWorkingCalendar.getId()); //id must no change
        assertEquals(1, capturedWorkingCalendar.getEmployeeId().getId());
        assertEquals(2, capturedWorkingCalendar.getCityId());
        assertEquals(5, capturedWorkingCalendar.getPriority());
        assertEquals(LocalDateTime.of(2020, 1, 1, 9, 30, 15), capturedWorkingCalendar.getStartDate());
        assertNull(capturedWorkingCalendar.getEndDate());
    }


}