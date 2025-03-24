package com.training.content.time_clock.application.mapper;

import com.training.content.time_clock.domain.TimeClock;
import com.training.content.time_clock.infrastructure.controller.dto.TimeClockOutputDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TimeClockMapper {

    TimeClockOutputDto domainToOutputDto(TimeClock timeClock);


}
