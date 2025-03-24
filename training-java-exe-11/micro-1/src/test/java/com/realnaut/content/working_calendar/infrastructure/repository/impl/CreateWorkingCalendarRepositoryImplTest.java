package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.TestData;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CreateWorkingCalendarRepositoryImplTest {

    @Autowired
    private CreateWorkingCalendarRepositoryImpl service;

    @MockBean
    private WorkingCalendarRepositoryJpa repoJpa;

    @Autowired
    private WorkingCalendarMapper mapper;

    @Test
    void create() {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar0();

        //When
        WorkingCalendar result = service.create(workingCalendar);

        //Then
        verify(repoJpa, times(1)).save(any());
    }
}