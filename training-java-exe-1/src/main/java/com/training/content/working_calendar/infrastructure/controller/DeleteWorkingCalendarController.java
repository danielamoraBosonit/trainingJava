package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.DeleteWorkingCalendarUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class DeleteWorkingCalendarController {

    private final DeleteWorkingCalendarUseCase useCase;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){

        useCase.deleteById(id);
    }

}
