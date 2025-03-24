package com.realnaut.content.working_calendar.application.impl;

import com.realnaut.content.working_calendar.application.GetWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.UpdateWorkingCalendarUseCase;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.UpdateWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarInputDto;
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

    private final WorkingCalendarMapper mapper;


    @Override
    public WorkingCalendar update(Integer id, WorkingCalendarInputDto inputDto) {

        getWorkingCalendarUseCase.getById(id);

        WorkingCalendar workingCalendarUpdated = mapper.inputDtoToDomain(inputDto);

        workingCalendarUpdated.setId(id);

        return repo.update(workingCalendarUpdated);
    }

    @Override
    public WorkingCalendar patchUpdate(Integer id, Map<String, Object> fields) {

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
