package com.realnaut.content.working_calendar.infrastructure.controller;

import com.realnaut.content.working_calendar.application.CreateWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/working-calendar")
public class CreateWorkingCalendarController {

    private final CreateWorkingCalendarUseCase useCase;

    public CreateWorkingCalendarController(CreateWorkingCalendarUseCase useCase) {
        this.useCase = useCase;
    }


    @PostMapping("/")
    public WorkingCalendarOutputDto create(@RequestBody WorkingCalendarInputDto inputDto){

        WorkingCalendar workingCalendar = useCase.create(inputDto);

        return new WorkingCalendarOutputDto(workingCalendar);
    }




}
