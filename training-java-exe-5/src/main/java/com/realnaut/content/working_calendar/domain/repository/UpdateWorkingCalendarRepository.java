package com.realnaut.content.working_calendar.domain.repository;

import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.error.CustomException;


public interface UpdateWorkingCalendarRepository {
    WorkingCalendar update(WorkingCalendar workingCalendar) throws CustomException;
}
