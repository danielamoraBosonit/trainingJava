package com.realnaut.content.working_calendar.application;

import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.error.CustomException;

import java.util.Map;


public interface UpdateWorkingCalendarUseCase {

    WorkingCalendar update(WorkingCalendar workingCalendar) throws CustomException;

    WorkingCalendar patchUpdate(Integer id, Map<String,Object> fields) throws CustomException;

}
