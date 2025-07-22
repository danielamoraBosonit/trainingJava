package com.training.content.working_calendar.application;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarFilters;

import java.util.List;

public interface GetWorkingCalendarUseCase {

    WorkingCalendar getById(Integer id);

    List<WorkingCalendar> getAll(WorkingCalendarFilters filters);

}
