package com.training.content.working_calendar.domain.repository;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarFilters;

import java.util.List;

public interface GetWorkingCalendarRepository {
    WorkingCalendar getById(Integer id);

    List<WorkingCalendar> getAll(WorkingCalendarFilters filters);
}
