package com.realnaut.content.time_clock.infrastructure.controller;

import com.realnaut.content.time_clock.application.GetTimeClockUseCase;
import com.realnaut.content.time_clock.application.mapper.TimeClockMapper;
import com.realnaut.content.time_clock.domain.entity.TimeClock;
import com.realnaut.content.time_clock.infrastructure.controller.dto.TimeClockOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/time-clock")
public class GetTimeClockController {

    private final GetTimeClockUseCase useCase;

    private final TimeClockMapper mapper;


    @GetMapping("/")
    public List<TimeClockOutputDto> getAll(@RequestParam (required = false) String email){

        List<TimeClock> timeClockList = useCase.getAllByEmail(email);

        return timeClockList.stream()
                .map(mapper::domainToOutputDto)
                .collect(Collectors.toList());
    }

}
