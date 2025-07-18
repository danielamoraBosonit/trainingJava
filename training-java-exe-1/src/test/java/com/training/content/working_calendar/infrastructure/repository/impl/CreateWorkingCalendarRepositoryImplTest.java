package com.training.content.working_calendar.infrastructure.repository.impl;

import com.training.content.TestData;
import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
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
    private WorkingCalendarRepositoryJpa jpaRepo;

    @Autowired
    private WorkingCalendarMapper mapper;

    @Test
    void create() {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar0();

        //When
        WorkingCalendar result = service.createWorkingCalendar(workingCalendar);

        //Then
        verify(jpaRepo, times(1)).save(any());

    }
}