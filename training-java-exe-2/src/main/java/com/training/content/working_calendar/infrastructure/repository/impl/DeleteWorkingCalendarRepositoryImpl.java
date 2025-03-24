package com.training.content.working_calendar.infrastructure.repository.impl;

import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.DeleteWorkingCalendarRepository;
import com.training.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.springframework.stereotype.Service;


@Service
public class DeleteWorkingCalendarRepositoryImpl implements DeleteWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    public DeleteWorkingCalendarRepositoryImpl(WorkingCalendarRepositoryJpa repoJpa) {
        this.repoJpa = repoJpa;
    }


    @Override
    public void delete(WorkingCalendar workingCalendar) {
        WorkingCalendarJpa workingCalendarJpa = new WorkingCalendarJpa(workingCalendar);

        repoJpa.delete(workingCalendarJpa);
    }
}
