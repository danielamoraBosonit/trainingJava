package com.training.content.working_calendar.application.impl;

import com.training.content.working_calendar.domain.repository.GetWorkingCalendarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class GetWorkingCalendarUseCaseImplTest {

    @Autowired
    private GetWorkingCalendarUseCaseImpl service;

    @MockBean
    private GetWorkingCalendarRepository repo;

    @Test
    void getById() {
        //Given

        //When
        service.getById(1);

        //Then
        verify(repo, times(1)).getById(1);

    }

    @Test
    void getAll() {
        //Given

        //When
        service.getAll();

        //Then
        verify(repo, times(1)).getAll();

    }

}