package com.training.content.working_calendar.domain.repository;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.error.CustomException;

public interface UpdateWorkingCalendarRepository {
    WorkingCalendar updateWorkingCalendar( WorkingCalendar workingCalendar) throws CustomException;
}

