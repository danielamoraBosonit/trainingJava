package com.realnaut.content.working_calendar.infrastructure.controller;

import com.realnaut.content.working_calendar.application.UpdateWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class UpdateWorkingCalendarController {

    private final UpdateWorkingCalendarUseCase useCase;

    private final WorkingCalendarMapper mapper;


    @PutMapping("/{id}")
    public WorkingCalendarOutputDto update(@PathVariable Integer id, @RequestBody WorkingCalendarInputDto inputDto){

        WorkingCalendar workingCalendar = useCase.update(id, inputDto);

        return mapper.domainToOutputDto(workingCalendar);
    }


    @PatchMapping("/{id}")
    public WorkingCalendarOutputDto patchUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields){

        WorkingCalendar workingCalendar = useCase.patchUpdate(id, fields);

        return mapper.domainToOutputDto(workingCalendar);
    }


}
