package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.UpdateWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import com.realnaut.error.CustomErrorType;
import com.realnaut.error.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class UpdateWorkingCalendarRepositoryImpl implements UpdateWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    private final WorkingCalendarMapper mapper;


    @Override
    public WorkingCalendar update(WorkingCalendar workingCalendar) throws CustomException {

        Optional<WorkingCalendarJpa> optionalWorkingCalendarJpa = repoJpa.findById(workingCalendar.getId());

        if (optionalWorkingCalendarJpa.isEmpty()){
            throw new CustomException(CustomErrorType.RESOURCE_NOT_FOUND);
        }

        WorkingCalendarJpa workingCalendarJpa = mapper.domainToJpa(workingCalendar);

        WorkingCalendarJpa workingCalendarJpaUpdated = repoJpa.save(workingCalendarJpa);

        return mapper.jpaToDomain(workingCalendarJpaUpdated);
    }
}
