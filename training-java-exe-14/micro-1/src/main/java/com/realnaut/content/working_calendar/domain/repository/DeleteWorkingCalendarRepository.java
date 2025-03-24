package com.realnaut.content.working_calendar.domain.repository;

import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;


public interface DeleteWorkingCalendarRepository {
    void delete(WorkingCalendar workingCalendar);
}
