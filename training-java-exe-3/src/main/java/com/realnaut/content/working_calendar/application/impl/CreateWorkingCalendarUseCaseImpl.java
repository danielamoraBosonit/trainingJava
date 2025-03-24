package com.realnaut.content.working_calendar.application.impl;

import com.realnaut.content.working_calendar.application.CreateWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.CreateWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CreateWorkingCalendarUseCaseImpl implements CreateWorkingCalendarUseCase {

    private final CreateWorkingCalendarRepository repo;

    private final WorkingCalendarMapper mapper;

    @Override
    public WorkingCalendar create(WorkingCalendarInputDto inputDto) {
        WorkingCalendar workingCalendar = mapper.inputDtoToDomain(inputDto);
        return repo.create(workingCalendar);
    }
}
