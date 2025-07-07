package com.training.content.working_calendar.infrastructure.repository.impl;

import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.GetWorkingCalendarRepository;
import com.training.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GetWorkingCalendarRepositoryImpl implements GetWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    private final WorkingCalendarMapper mapper;

    @Override
    public WorkingCalendar getById(Integer id) {

        WorkingCalendarJpa workingCalendarJpa = repoJpa.getReferenceById(id);

        return mapper.jpaToDomain(workingCalendarJpa);
    }

    @Override
    public List<WorkingCalendar> getAll() {
        List<WorkingCalendarJpa> workingCalendarJpaList = repoJpa.findAll();

        return workingCalendarJpaList.stream()
                .map(mapper::jpaToDomain)
                .collect(Collectors.toList());
    }
}
