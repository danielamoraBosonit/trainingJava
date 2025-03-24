package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.TestData;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetWorkingCalendarRepositoryImplTest {

    @Autowired
    private GetWorkingCalendarRepositoryImpl service;

    @MockBean
    private WorkingCalendarRepositoryJpa repoJpa;

    @Autowired
    private WorkingCalendarMapper mapper;

    @Test
    void getById() {
        //Given
        WorkingCalendarJpa workingCalendarJpa = TestData.getWorkingCalendarJpa1();

        when(repoJpa.getReferenceById(anyInt())).thenReturn(workingCalendarJpa);

        //When
        WorkingCalendar result = service.getById(1);

        //Then
        assertEquals(workingCalendarJpa.getId(), result.getId());
        assertEquals(workingCalendarJpa.getEmployeeId(), result.getEmployeeId());
        assertEquals(workingCalendarJpa.getStartDate(), result.getStartDate());
        assertEquals(workingCalendarJpa.getEndDate(), result.getEndDate());
        assertEquals(workingCalendarJpa.getCityId(), result.getCityId());
        assertEquals(workingCalendarJpa.getPriority(), result.getPriority());
    }

    @Test
    void getAll() {
        //Given
        List<WorkingCalendarJpa> workingCalendarJpaList = new ArrayList<>();
        workingCalendarJpaList.add(TestData.getWorkingCalendarJpa1());
        workingCalendarJpaList.add(TestData.getWorkingCalendarJpa2());
        workingCalendarJpaList.add(TestData.getWorkingCalendarJpa3());
        workingCalendarJpaList.add(TestData.getWorkingCalendarJpa4());

        when(repoJpa.findAll()).thenReturn(workingCalendarJpaList);

        //When
        List<WorkingCalendar> result = service.getAll();

        //Then
        assertEquals(workingCalendarJpaList.size(), result.size());

    }
}