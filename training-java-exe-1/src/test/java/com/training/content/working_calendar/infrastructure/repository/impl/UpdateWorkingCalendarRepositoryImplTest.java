package com.training.content.working_calendar.infrastructure.repository.impl;

import com.training.content.TestData;
import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import com.training.error.CustomException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class UpdateWorkingCalendarRepositoryImplTest {

    @Autowired
    private UpdateWorkingCalendarRepositoryImpl service;

    @MockBean
    private WorkingCalendarRepositoryJpa repoJpa;

    @Autowired
    private WorkingCalendarMapper mapper;

    @Test
    void update() throws CustomException {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar1();
        WorkingCalendarJpa workingCalendarJpa = TestData.getWorkingCalendarJpa1();

        when(repoJpa.findById(anyInt())).thenReturn(Optional.of(workingCalendarJpa));

        //When
        WorkingCalendar result = service.updateWorkingCalendar(workingCalendar);

        //Then
        verify(repoJpa, times(1)).save(any());
    }


    @Test
    void updateWithWorkingCalendarNotFound() {
        //Given
        WorkingCalendar workingCalendar = TestData.getWorkingCalendar1();

        when(repoJpa.findById(anyInt())).thenReturn(Optional.empty());

        //When
        assertThrows(CustomException.class, () -> {
            service.updateWorkingCalendar(workingCalendar);
        });

        //Then
        verify(repoJpa, times(0)).save(any());
    }


}