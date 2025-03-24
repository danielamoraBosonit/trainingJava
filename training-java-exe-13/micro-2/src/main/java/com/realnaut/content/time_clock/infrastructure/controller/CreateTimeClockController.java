package com.realnaut.content.time_clock.infrastructure.controller;

import com.realnaut.content.time_clock.application.CreateTimeClockUseCase;
import com.realnaut.content.time_clock.application.PublishMsgTimeClockUseCase;
import com.realnaut.content.time_clock.application.mapper.TimeClockMapper;
import com.realnaut.content.time_clock.domain.entity.TimeClock;
import com.realnaut.content.time_clock.infrastructure.controller.dto.TimeClockInputDto;
import com.realnaut.content.time_clock.infrastructure.controller.dto.TimeClockOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/time-clock")
public class CreateTimeClockController {

    private final CreateTimeClockUseCase useCase;

    private final TimeClockMapper mapper;

    private final PublishMsgTimeClockUseCase publisher;


    @PostMapping("/")
    public TimeClockOutputDto create(@RequestBody TimeClockInputDto inputDto) throws Exception {

        TimeClock timeClockFromInput = mapper.inputDtoToDomain(inputDto);

        TimeClock timeClock = useCase.create(timeClockFromInput);

        TimeClockOutputDto timeClockOutputDto = mapper.domainToOutputDto(timeClock);

        publisher.sendTimeClockMessage(timeClockOutputDto);

        return timeClockOutputDto;
    }




}
