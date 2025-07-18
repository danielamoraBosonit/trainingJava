package com.training.content.working_calendar.application.mapper;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public interface WorkingCalendarMapper {

    WorkingCalendarJpa domainToJpa(WorkingCalendar workingCalendar);
    WorkingCalendar jpaToDomain(WorkingCalendarJpa workingCalendarJpa);

    WorkingCalendar inputDtoToDomain(WorkingCalendarInputDto workingCalendarInputDto);

    @Mapping(target = "interval",
            expression = "java(calculateInterval(workingCalendar.getStartDate(), workingCalendar.getEndDate()))")
    WorkingCalendarOutputDto domainToOutputDto(WorkingCalendar workingCalendar);

    default Integer calculateInterval(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate != null && endDate != null){
            return (Integer) (int) ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate());
        }

        return null;
    }
}
