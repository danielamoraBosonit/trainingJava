package com.realnaut.content.time_clock.application.mapper;

import com.realnaut.content.time_clock.domain.entity.TimeClock;
import com.realnaut.content.time_clock.infrastructure.controller.dto.TimeClockInputDto;
import com.realnaut.content.time_clock.infrastructure.controller.dto.TimeClockOutputDto;
import com.realnaut.content.time_clock.infrastructure.repository.mongo.entity.TimeClockMongoDB;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TimeClockMapper {

    TimeClock mongoDbToDomain(TimeClockMongoDB timeClockMongoDB);

    TimeClockOutputDto domainToOutputDto(TimeClock TimeClock);

    TimeClock inputDtoToDomain(TimeClockInputDto inputDto);

    TimeClockMongoDB domainToMongoDB(TimeClock TimeClock);

}
