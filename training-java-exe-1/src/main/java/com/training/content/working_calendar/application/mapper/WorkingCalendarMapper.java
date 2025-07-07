package com.training.content.working_calendar.application.mapper;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarOutputDto;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkingCalendarMapper {

    WorkingCalendarOutputDto domainToOutputDto(WorkingCalendar workingCalendar);
    WorkingCalendar inputDtoToDomain(WorkingCalendarInputDto workingCalendarInputDto);

    WorkingCalendarJpa domainToJpa(WorkingCalendar workingCalendar);
    WorkingCalendar jpaToDomain(WorkingCalendarJpa workingCalendarJpa);
}
