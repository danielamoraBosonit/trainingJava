package com.training.content.working_calendar.infrastructure.repository.impl;

import com.training.content.working_calendar.domain.repository.DeleteWorkingCalendarRepository;
import com.training.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteWorkingCalendarRepositoryImpl implements DeleteWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;


    @Override
    public void deleteById(Integer id) {
        repoJpa.deleteById(id);
    }
}
