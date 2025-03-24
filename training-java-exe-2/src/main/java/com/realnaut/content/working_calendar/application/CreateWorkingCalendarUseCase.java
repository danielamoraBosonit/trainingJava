package com.realnaut.content.working_calendar.application;

import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;


public interface CreateWorkingCalendarUseCase {

    WorkingCalendar create(WorkingCalendarInputDto inputDto);

}
