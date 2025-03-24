package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.CreateWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateWorkingCalendarRepositoryImpl implements CreateWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    private final WorkingCalendarMapper mapper;



    @Override
    public WorkingCalendar create(WorkingCalendar workingCalendar) {

        WorkingCalendarJpa workingCalendarJpa = mapper.domainToJpa(workingCalendar);

        WorkingCalendarJpa workingCalendarJpaCreated = repoJpa.save(workingCalendarJpa);

        return mapper.jpaToDomain(workingCalendarJpaCreated);
    }
}
