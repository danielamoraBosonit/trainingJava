package com.realnaut.content.working_calendar.application.impl;

import com.realnaut.content.working_calendar.application.CreateWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.CreateWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import org.springframework.stereotype.Service;


@Service
public class CreateWorkingCalendarUseCaseImpl implements CreateWorkingCalendarUseCase {

    private final CreateWorkingCalendarRepository repo;

    public CreateWorkingCalendarUseCaseImpl(CreateWorkingCalendarRepository repo) {
        this.repo = repo;
    }

    @Override
    public WorkingCalendar create(WorkingCalendarInputDto inputDto) {
        WorkingCalendar workingCalendar = new WorkingCalendar(inputDto);
        return repo.create(workingCalendar);
    }
}
