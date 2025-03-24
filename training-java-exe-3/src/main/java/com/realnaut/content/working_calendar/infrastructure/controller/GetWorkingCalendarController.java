package com.realnaut.content.working_calendar.infrastructure.controller;

import com.realnaut.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class GetWorkingCalendarController {

    private final GetWorkingCalendarUseCase useCase;

    private final WorkingCalendarMapper mapper;



    @GetMapping("/")
    public List<WorkingCalendarOutputDto> getAll(){

        List<WorkingCalendar> workingCalendarList = useCase.getAll();

        return workingCalendarList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public WorkingCalendarOutputDto getById(@PathVariable Integer id){

        WorkingCalendar workingCalendar = useCase.getById(id);

        return mapper.domainToOutputDto(workingCalendar);
    }




}
