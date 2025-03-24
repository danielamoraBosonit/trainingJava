package com.realnaut.content.working_calendar.infrastructure.repository.impl;

import com.realnaut.content.employee.infrastructure.repository.jpa.EmployeeRepositoryJpa;
import com.realnaut.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import com.realnaut.content.working_calendar.application.mapper.WorkingCalendarMapper;
import com.realnaut.content.working_calendar.domain.entity.WorkingCalendar;
import com.realnaut.content.working_calendar.domain.repository.GetWorkingCalendarRepository;
import com.realnaut.content.working_calendar.infrastructure.controller.dto.WorkingCalendarFilters;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.WorkingCalendarRepositoryJpa;
import com.realnaut.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;
import com.realnaut.shared.criteria.CriteriaJpaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GetWorkingCalendarRepositoryImpl implements GetWorkingCalendarRepository {

    private final WorkingCalendarRepositoryJpa repoJpa;

    private final WorkingCalendarMapper mapper;

    private final CriteriaJpaBuilder<WorkingCalendarJpa> criteriaJpaBuilder;

    private final EmployeeRepositoryJpa employeeRepositoryJpa;

    @Override
    public WorkingCalendar getById(Integer id) {

        WorkingCalendarJpa workingCalendarJpa = repoJpa.getReferenceById(id);

        return mapper.jpaToDomain(workingCalendarJpa);
    }

    @Override
    public List<WorkingCalendar> getAll(WorkingCalendarFilters filters) {
        Specification<WorkingCalendarJpa> specifications = null;

        if (filters != null) {
            specifications = setSpecifications(filters);
        }

        List<WorkingCalendarJpa> workingCalendarJpaList = repoJpa.findAll(Specification.where(specifications));

        return workingCalendarJpaList.stream()
                .map(mapper::jpaToDomain)
                .collect(Collectors.toList());
    }


    private Specification<WorkingCalendarJpa> setSpecifications(WorkingCalendarFilters filters){
        Specification<WorkingCalendarJpa> specifications = null;

        specifications = criteriaJpaBuilder.addSpec(filters.getId(), "id", specifications);
        specifications = criteriaJpaBuilder.addSpec(filters.getCityId(), "cityId", specifications);
        specifications = criteriaJpaBuilder.addSpec(filters.getPriority(), "priority", specifications);

        if (filters.getEmployeeId() != null){
            EmployeeJpa employeeJpa = employeeRepositoryJpa.getReferenceById(filters.getEmployeeId());
            specifications = criteriaJpaBuilder.addSpec(employeeJpa, "employeeId", specifications);
        }

        return specifications;
    }
}
