package com.training.content.working_calendar.application;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;

import java.util.List;
import java.util.Map;

public interface UpdateWorkingCalendarUseCase {

    WorkingCalendar updateWorkingCalendar(Integer id, WorkingCalendarInputDto workingCalendarInputDto);

    WorkingCalendar patchUpdateWorkingCalendar(Integer id, Map<String, Object> fields);
}
