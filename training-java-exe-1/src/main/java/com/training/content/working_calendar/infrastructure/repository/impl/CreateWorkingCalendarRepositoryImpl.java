package com.training.content.working_calendar.infrastructure.repository.impl;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.CreateWorkingCalendarRepository;
import com.training.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.springframework.stereotype.Service;

@Service
public class CreateWorkingCalendarRepositoryImpl implements CreateWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    public CreateWorkingCalendarRepositoryImpl(WorkingCalendarRepositoryJpa repoJpa)  { this.repoJpa = repoJpa; }

    @Override
    public WorkingCalendar createWorkingCalendar(WorkingCalendar workingCalendar) {
        WorkingCalendarJpa workingCalendarJpa = new WorkingCalendarJpa(workingCalendar);

        WorkingCalendarJpa workingCalendarJpaCreated = repoJpa.save(workingCalendarJpa);
        return new WorkingCalendar(workingCalendarJpaCreated);
    }
}
