package com.training.content.working_calendar.application.impl;

import com.training.content.TestData;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.DeleteWorkingCalendarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DeleteWorkingCalendarUseCaseImplTest {

    @Autowired
    private DeleteWorkingCalendarUseCaseImpl service;

    @MockBean
    private DeleteWorkingCalendarRepository repo;

    @MockBean
    private GetWorkingCalendarUseCaseImpl getWorkingCalendarUseCase;

    @Test
    void delete() {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar1();
        when(getWorkingCalendarUseCase.getById(1)).thenReturn(workingCalendar);

        //When
        service.delete(1);

        //Then
        verify(repo, times(1)).delete(workingCalendar);

    }

}