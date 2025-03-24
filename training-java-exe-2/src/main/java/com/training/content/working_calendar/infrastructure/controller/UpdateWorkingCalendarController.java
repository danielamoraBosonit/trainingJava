package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.UpdateWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/working-calendar")
public class UpdateWorkingCalendarController {

    private final UpdateWorkingCalendarUseCase useCase;

    public UpdateWorkingCalendarController(UpdateWorkingCalendarUseCase useCase) {
        this.useCase = useCase;
    }


    @PutMapping("/{id}")
    public WorkingCalendarOutputDto update(@PathVariable Integer id, @RequestBody WorkingCalendarInputDto inputDto){

        WorkingCalendar workingCalendar = useCase.update(id, inputDto);

        return new WorkingCalendarOutputDto(workingCalendar);
    }


    @PatchMapping("/{id}")
    public WorkingCalendarOutputDto patchUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields){

        WorkingCalendar workingCalendar = useCase.patchUpdate(id, fields);

        return new WorkingCalendarOutputDto(workingCalendar);
    }


}
