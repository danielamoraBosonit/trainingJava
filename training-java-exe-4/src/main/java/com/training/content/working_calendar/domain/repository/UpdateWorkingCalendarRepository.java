package com.training.content.working_calendar.domain.repository;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;


public interface UpdateWorkingCalendarRepository {
    WorkingCalendar update(WorkingCalendar workingCalendar);
}
