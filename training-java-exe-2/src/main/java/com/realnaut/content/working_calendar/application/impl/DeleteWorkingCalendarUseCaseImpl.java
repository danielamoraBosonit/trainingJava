package com.realnaut.content.working_calendar.application.impl;

import com.realnaut.content.working_calendar.application.DeleteWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.DeleteWorkingCalendarRepository;
import org.springframework.stereotype.Service;


@Service
public class DeleteWorkingCalendarUseCaseImpl implements DeleteWorkingCalendarUseCase {

    private final DeleteWorkingCalendarRepository repo;

    private final GetWorkingCalendarUseCase getWorkingCalendarUseCase;

    public DeleteWorkingCalendarUseCaseImpl(DeleteWorkingCalendarRepository repo, GetWorkingCalendarUseCase getWorkingCalendarUseCase) {
        this.repo = repo;
        this.getWorkingCalendarUseCase = getWorkingCalendarUseCase;
    }

    @Override
    public void delete(Integer id) {
        WorkingCalendar workingCalendar = getWorkingCalendarUseCase.getById(id);
        repo.delete(workingCalendar);
    }


}
