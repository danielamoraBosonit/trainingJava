package com.training.content.working_calendar.domain.repository;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;

public interface DeleteWorkingCalendarRepository {
    void delete(WorkingCalendar workingCalendar);
}
