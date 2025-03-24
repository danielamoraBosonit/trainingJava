package com.training.content.working_calendar.application.impl;

import com.training.content.working_calendar.application.CreateWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.CreateWorkingCalendarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CreateWorkingCalendarUseCaseImpl implements CreateWorkingCalendarUseCase {

    private final CreateWorkingCalendarRepository repo;


    @Override
    public WorkingCalendar create(WorkingCalendar workingCalendar) {
        return repo.create(workingCalendar);
    }
}
