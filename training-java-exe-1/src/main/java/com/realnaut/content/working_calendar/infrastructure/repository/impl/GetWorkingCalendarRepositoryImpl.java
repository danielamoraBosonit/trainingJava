package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.GetWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetWorkingCalendarRepositoryImpl implements GetWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    public GetWorkingCalendarRepositoryImpl(WorkingCalendarRepositoryJpa repoJpa) {
        this.repoJpa = repoJpa;
    }

    @Override
    public WorkingCalendar getById(Integer id) {

        WorkingCalendarJpa workingCalendarJpa = repoJpa.getReferenceById(id);

        return new WorkingCalendar(workingCalendarJpa);
    }

    @Override
    public List<WorkingCalendar> getAll() {
        List<WorkingCalendarJpa> workingCalendarJpaList = repoJpa.findAll();

        return workingCalendarJpaList.stream()
                .map(WorkingCalendar::new)
                .collect(Collectors.toList());
    }
}
