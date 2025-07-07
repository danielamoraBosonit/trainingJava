package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.UpdateWorkingCalendarUseCase;
import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
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
    public WorkingCalendarOutputDto getById(@PathVariable Integer id, @RequestBody WorkingCalendarInputDto workingCalendarInputDto){

        WorkingCalendar workingCalendar = useCase.updateWorkingCalendar(id, workingCalendarInputDto);

        return mapper.domainToOutputDto(workingCalendar);
    }

    @PatchMapping("/{id}")
    public WorkingCalendarOutputDto getById(@PathVariable Integer id, @RequestBody Map<String, Object> fields){

        WorkingCalendar workingCalendar = useCase.patchUpdateWorkingCalendar(id, fields);

        return mapper.domainToOutputDto(workingCalendar);
    }


}
