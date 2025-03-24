package com.realnaut.content.working_calendar.application.mapper;

import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public interface WorkingCalendarMapper {

    WorkingCalendar jpaToDomain(WorkingCalendarJpa workingCalendarJpa);

    WorkingCalendar inputDtoToDomain(WorkingCalendarInputDto inputDto);

    WorkingCalendarJpa domainToJpa(WorkingCalendar workingCalendar);

    @Mapping(target = "interval",
            expression = "java(calcInterval(workingCalendar.getStartDate(), workingCalendar.getEndDate()))")
    WorkingCalendarOutputDto domainToOutputDto(WorkingCalendar workingCalendar);

    default Integer calcInterval(LocalDateTime startDate, LocalDateTime endDate){
        if (startDate != null && endDate != null){
            Integer interval = (int)ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate());
            return interval;
        }
        return null;
    }

}
