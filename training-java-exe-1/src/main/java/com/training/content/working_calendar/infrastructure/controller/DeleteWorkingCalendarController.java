package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.DeleteWorkingCalendarUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/working-calendar")
public class DeleteWorkingCalendarController {

    private final DeleteWorkingCalendarUseCase useCase;

    public DeleteWorkingCalendarController(DeleteWorkingCalendarUseCase useCase) {
        this.useCase = useCase;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){

        useCase.deleteById(id);

    }

}
