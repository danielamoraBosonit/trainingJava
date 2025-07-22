package com.training.content.working_calendar.application.impl;

import com.training.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.GetWorkingCalendarRepository;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarFilters;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetWorkingCalendarUseCaseImpl implements GetWorkingCalendarUseCase {

    private final GetWorkingCalendarRepository repo;

    @Override
    public WorkingCalendar getById(Integer id){

        return repo.getById(id);
    }


    @Override
    public List<WorkingCalendar> getAll(WorkingCalendarFilters filters){

        return repo.getAll(filters);
    }


}
