package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.TestData;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DeleteWorkingCalendarRepositoryImplTest {

    @Autowired
    private DeleteWorkingCalendarRepositoryImpl service;

    @MockBean
    private WorkingCalendarRepositoryJpa repoJpa;

    @Autowired
    private WorkingCalendarMapper mapper;


    @Test
    void delete() {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar1();

        //When
        service.delete(workingCalendar);

        ArgumentCaptor<WorkingCalendarJpa> captor = ArgumentCaptor.forClass(WorkingCalendarJpa.class);
        verify(repoJpa).delete(captor.capture());
        WorkingCalendarJpa capturedWorkingCalendarJpa = captor.getValue();

        //Then
        verify(repoJpa, times(1)).delete(any(WorkingCalendarJpa.class));
        assertEquals(capturedWorkingCalendarJpa.getId(), workingCalendar.getId()); //id must no change
        assertEquals(capturedWorkingCalendarJpa.getEmployeeId().getId(), workingCalendar.getEmployeeId().getId());
        assertEquals(capturedWorkingCalendarJpa.getCityId(), workingCalendar.getCityId());
        assertEquals(capturedWorkingCalendarJpa.getPriority(), workingCalendar.getPriority());
        assertEquals(capturedWorkingCalendarJpa.getStartDate(), workingCalendar.getStartDate());
        assertEquals(capturedWorkingCalendarJpa.getEndDate(), workingCalendar.getEndDate());
    }
}