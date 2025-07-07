package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.content.working_calendar.application.CreateWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;

@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class CreateWorkingCalendarController {

    private final CreateWorkingCalendarUseCase useCase;

    private final WorkingCalendarMapper mapper;

    @PostMapping("/")
    public WorkingCalendarOutputDto createWorkingCalendar(@RequestBody WorkingCalendarInputDto workingCalendarInputDto) {
        WorkingCalendar workingCalendar = useCase.createWorkingCalendar(workingCalendarInputDto);

        return mapper.domainToOutputDto(workingCalendar);
    }

}
