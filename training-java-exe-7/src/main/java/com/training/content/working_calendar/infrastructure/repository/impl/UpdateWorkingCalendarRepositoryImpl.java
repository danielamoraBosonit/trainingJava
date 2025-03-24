package com.training.content.working_calendar.infrastructure.repository.impl;

import com.training.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.UpdateWorkingCalendarRepository;
import com.training.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import com.training.error.CustomErrorType;
import com.training.error.CustomException;
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
