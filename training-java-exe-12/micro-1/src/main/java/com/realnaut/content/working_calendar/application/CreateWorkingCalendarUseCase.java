package com.realnaut.content.working_calendar.application;

import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;


public interface CreateWorkingCalendarUseCase {

    WorkingCalendar create(WorkingCalendar workingCalendar);

}
