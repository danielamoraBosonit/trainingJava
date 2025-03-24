package com.training.content.working_calendar.application;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;

import java.util.Map;


public interface UpdateWorkingCalendarUseCase {

    WorkingCalendar update(Integer id, WorkingCalendarInputDto inputDto);

    WorkingCalendar patchUpdate(Integer id, Map<String,Object> fields);

}
