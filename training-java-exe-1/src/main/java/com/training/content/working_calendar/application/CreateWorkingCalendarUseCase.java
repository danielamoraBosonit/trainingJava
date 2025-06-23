package com.training.content.working_calendar.application;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;

public interface CreateWorkingCalendarUseCase {
    WorkingCalendar createWorkingCalendar(WorkingCalendarInputDto workingCalendar);
}
