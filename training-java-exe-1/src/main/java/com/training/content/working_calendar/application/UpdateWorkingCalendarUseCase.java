package com.training.content.working_calendar.application;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.error.CustomException;

import java.util.Map;

public interface UpdateWorkingCalendarUseCase {

    WorkingCalendar updateWorkingCalendar(WorkingCalendar workingCalendar) throws CustomException;

    WorkingCalendar patchUpdateWorkingCalendar(Integer id, Map<String, Object> fields) throws CustomException;
}
