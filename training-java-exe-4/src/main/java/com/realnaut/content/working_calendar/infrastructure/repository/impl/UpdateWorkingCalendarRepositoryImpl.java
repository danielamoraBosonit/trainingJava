package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.UpdateWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UpdateWorkingCalendarRepositoryImpl implements UpdateWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    private final WorkingCalendarMapper mapper;


    @Override
    public WorkingCalendar update(WorkingCalendar workingCalendar) {

        WorkingCalendarJpa workingCalendarJpa = mapper.domainToJpa(workingCalendar);

        WorkingCalendarJpa workingCalendarJpaUpdated = repoJpa.save(workingCalendarJpa);

        return mapper.jpaToDomain(workingCalendarJpaUpdated);
    }
}
