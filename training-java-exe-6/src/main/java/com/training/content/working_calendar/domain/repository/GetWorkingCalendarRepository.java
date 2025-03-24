package com.training.content.working_calendar.domain.repository;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;

import java.util.List;

public interface GetWorkingCalendarRepository {
    WorkingCalendar getById(Integer id);

    List<WorkingCalendar> getAll();
}
