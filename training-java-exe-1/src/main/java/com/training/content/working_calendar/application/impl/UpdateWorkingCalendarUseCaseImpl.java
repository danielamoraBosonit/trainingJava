package com.training.content.working_calendar.application.impl;

import com.training.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.training.content.working_calendar.application.UpdateWorkingCalendarUseCase;
import com.training.content.working_calendar.domain.entity.WorkingCalendar;
import com.training.content.working_calendar.domain.repository.UpdateWorkingCalendarRepository;
import com.training.error.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@AllArgsConstructor
@Service
public class UpdateWorkingCalendarUseCaseImpl implements UpdateWorkingCalendarUseCase {

    private final UpdateWorkingCalendarRepository repo;

    private final GetWorkingCalendarUseCase getWorkingCalendarUseCase;

    @Override
    public WorkingCalendar updateWorkingCalendar(WorkingCalendar workingCalendar) throws CustomException {

        return this.repo.updateWorkingCalendar(workingCalendar);
    }

    @Override
    public WorkingCalendar patchUpdateWorkingCalendar(Integer id, Map<String, Object> fields) throws CustomException {

        WorkingCalendar workingCalendar = getWorkingCalendarUseCase.getById(id);

        for (Map.Entry<String, Object> entry: fields.entrySet()) {
            if (!entry.getKey().equals("id")) {
                Field field = ReflectionUtils.findField(WorkingCalendar.class, entry.getKey());
                field.setAccessible(true);
                ReflectionUtils.setField(field, workingCalendar, entry.getValue());
            }
        }

        return this.repo.updateWorkingCalendar(workingCalendar);
    }
}
