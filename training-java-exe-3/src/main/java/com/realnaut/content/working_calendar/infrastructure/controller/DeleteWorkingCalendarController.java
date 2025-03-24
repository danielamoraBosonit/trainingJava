package com.realnaut.content.working_calendar.infrastructure.controller;

import com.realnaut.content.working_calendar.application.DeleteWorkingCalendarUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/working-calendar")
public class DeleteWorkingCalendarController {

    private final DeleteWorkingCalendarUseCase useCase;


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

        useCase.delete(id);

    }

}
