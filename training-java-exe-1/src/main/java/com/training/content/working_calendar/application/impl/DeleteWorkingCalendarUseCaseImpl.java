package com.training.content.working_calendar.application.impl;

import com.training.content.working_calendar.application.DeleteWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.CreateWorkingCalendarRepository;
import com.training.content.working_calendar.domain.repository.DeleteWorkingCalendarRepository;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteWorkingCalendarUseCaseImpl implements DeleteWorkingCalendarUseCase {

    private final DeleteWorkingCalendarRepository repo;

    @Override
    public void deleteById(Integer id) {
        this.repo.deleteById(id);
    }
}
