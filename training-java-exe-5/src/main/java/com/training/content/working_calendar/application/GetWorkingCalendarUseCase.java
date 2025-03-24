package com.training.content.working_calendar.application;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;

import java.util.List;

public interface GetWorkingCalendarUseCase {

    WorkingCalendar getById(Integer id);

    List<WorkingCalendar> getAll();

}
