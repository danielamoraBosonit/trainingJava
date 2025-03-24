package com.training.content.working_calendar.application;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.error.CustomException;

import java.util.Map;


public interface UpdateWorkingCalendarUseCase {

    WorkingCalendar update(WorkingCalendar workingCalendar) throws CustomException;

    WorkingCalendar patchUpdate(Integer id, Map<String,Object> fields) throws CustomException;

}
