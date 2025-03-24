package com.training.content.working_calendar.application.impl;

import com.training.TestData;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.CreateWorkingCalendarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreateWorkingCalendarUseCaseImplTest {

    @Autowired
    private CreateWorkingCalendarUseCaseImpl service;

    @MockBean
    private CreateWorkingCalendarRepository repo;

    @Test
    void create() {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar1();

        when(repo.create(any())).thenReturn(workingCalendar);

        //When
        WorkingCalendar result = service.create(new WorkingCalendar());

        //Then
        assertEquals(workingCalendar, result);

    }
}