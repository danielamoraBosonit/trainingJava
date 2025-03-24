package com.training.content.working_calendar.application.impl;

import com.training.content.working_calendar.application.DeleteWorkingCalendarUseCase;
import com.training.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.DeleteWorkingCalendarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteWorkingCalendarUseCaseImpl implements DeleteWorkingCalendarUseCase {

    private final DeleteWorkingCalendarRepository repo;

    private final GetWorkingCalendarUseCase getWorkingCalendarUseCase;

    @Override
    public void delete(Integer id) {
        WorkingCalendar workingCalendar = getWorkingCalendarUseCase.getById(id);
        repo.delete(workingCalendar);
    }


}
