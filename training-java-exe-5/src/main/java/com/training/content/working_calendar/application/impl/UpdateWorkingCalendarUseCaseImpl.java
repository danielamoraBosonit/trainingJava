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
    public WorkingCalendar update(WorkingCalendar workingCalendar) throws CustomException {

        return repo.update(workingCalendar);

    }

    @Override
    public WorkingCalendar patchUpdate(Integer id, Map<String, Object> fields) throws CustomException {

        WorkingCalendar workingCalendar = getWorkingCalendarUseCase.getById(id);

        for (Map.Entry<String,Object> entry : fields.entrySet()) {
            if (!entry.getKey().equals("id")){
                Field field = ReflectionUtils.findField(WorkingCalendar.class, entry.getKey());
                field.setAccessible(true);
                ReflectionUtils.setField(field, workingCalendar, entry.getValue());
            }
        }

        return repo.update(workingCalendar);
    }
}
