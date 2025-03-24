package com.training.content.working_calendar.application.mapper;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public interface WorkingCalendarMapper {

    WorkingCalendar jpaToDomain(WorkingCalendarJpa workingCalendarJpa);

    @Mapping(source = "employeeId", target = "employeeId.id")
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
