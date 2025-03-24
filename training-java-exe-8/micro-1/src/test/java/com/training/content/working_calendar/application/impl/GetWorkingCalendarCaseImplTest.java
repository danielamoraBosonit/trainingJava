package com.training.content.working_calendar.application.impl;

import com.training.TestData;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.GetWorkingCalendarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetWorkingCalendarCaseImplTest {

    @Autowired
    private GetWorkingCalendarUseCaseImpl service;

    @MockBean
    private GetWorkingCalendarRepository repo;

    @Test
    void getById() {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar1();

        when(repo.getById(anyInt())).thenReturn(workingCalendar);

        //When
        WorkingCalendar result = service.getById(1);

        //Then
        assertEquals(workingCalendar, result);

    }

    @Test
    void getAll() {
        //Given
        List<WorkingCalendar> workingCalendarList = new ArrayList<>();
        workingCalendarList.add(TestData.getWorkingCalendar1());
        workingCalendarList.add(TestData.getWorkingCalendar2());
        workingCalendarList.add(TestData.getWorkingCalendar3());
        workingCalendarList.add(TestData.getWorkingCalendar4());

        when(repo.getAll(any())).thenReturn(workingCalendarList);

        //When
        List<WorkingCalendar> result = service.getAll(any());

        //Then
        assertEquals(workingCalendarList.size(), result.size());

    }
}