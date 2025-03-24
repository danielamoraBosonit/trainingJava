package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.UpdateWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.springframework.stereotype.Service;


@Service
public class UpdateWorkingCalendarRepositoryImpl implements UpdateWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    public UpdateWorkingCalendarRepositoryImpl(WorkingCalendarRepositoryJpa repoJpa) {
        this.repoJpa = repoJpa;
    }


    @Override
    public WorkingCalendar update(WorkingCalendar workingCalendar) {

        WorkingCalendarJpa workingCalendarJpa = new WorkingCalendarJpa(workingCalendar);

        WorkingCalendarJpa workingCalendarJpaUpdated = repoJpa.save(workingCalendarJpa);

        return new WorkingCalendar(workingCalendarJpaUpdated);
    }
}
