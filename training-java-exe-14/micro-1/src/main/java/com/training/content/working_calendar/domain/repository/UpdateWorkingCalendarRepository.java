package com.training.content.working_calendar.domain.repository;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.error.CustomException;


public interface UpdateWorkingCalendarRepository {
    WorkingCalendar update(WorkingCalendar workingCalendar) throws CustomException;
}
