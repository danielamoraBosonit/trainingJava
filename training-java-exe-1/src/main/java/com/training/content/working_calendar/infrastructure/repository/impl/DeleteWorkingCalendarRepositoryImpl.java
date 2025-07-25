package com.training.content.working_calendar.infrastructure.repository.impl;

import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.DeleteWorkingCalendarRepository;
import com.training.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteWorkingCalendarRepositoryImpl implements DeleteWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    private final WorkingCalendarMapper mapper;


    @Override
    public void delete(WorkingCalendar workingCalendar) {
        WorkingCalendarJpa workingCalendarJpa = mapper.domainToJpa(workingCalendar);
        repoJpa.delete(workingCalendarJpa);
    }
}
