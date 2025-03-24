package com.realnaut.content.working_calendar.application.impl;

import com.realnaut.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.GetWorkingCalendarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetWorkingCalendarUseCaseImpl implements GetWorkingCalendarUseCase {

    private final GetWorkingCalendarRepository repo;

    public GetWorkingCalendarUseCaseImpl(GetWorkingCalendarRepository repo) {
        this.repo = repo;
    }

    @Override
    public WorkingCalendar getById(Integer id){

        return repo.getById(id);
    }


    @Override
    public List<WorkingCalendar> getAll(){

        return repo.getAll();
    }


}
