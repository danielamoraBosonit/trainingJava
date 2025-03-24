package com.realnaut.content.working_calendar.infrastructure.controller;

import com.realnaut.content.working_calendar.application.CreateWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class CreateWorkingCalendarController {

    private final CreateWorkingCalendarUseCase useCase;

    private final WorkingCalendarMapper mapper;



    @PostMapping("/")
    public WorkingCalendarOutputDto create(@RequestBody WorkingCalendarInputDto inputDto){

        WorkingCalendar workingCalendar = useCase.create(inputDto);

        return mapper.domainToOutputDto(workingCalendar);
    }




}
