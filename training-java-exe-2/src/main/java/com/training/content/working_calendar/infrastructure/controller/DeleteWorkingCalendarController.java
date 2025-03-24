package com.training.content.working_calendar.infrastructure.controller;

import com.training.content.working_calendar.application.DeleteWorkingCalendarUseCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/working-calendar")
public class DeleteWorkingCalendarController {

    private final DeleteWorkingCalendarUseCase useCase;

    public DeleteWorkingCalendarController(DeleteWorkingCalendarUseCase useCase) {
        this.useCase = useCase;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

        useCase.delete(id);

    }

}
