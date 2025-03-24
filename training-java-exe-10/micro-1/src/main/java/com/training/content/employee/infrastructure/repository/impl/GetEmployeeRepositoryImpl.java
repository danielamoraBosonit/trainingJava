package com.training.content.employee.infrastructure.repository.impl;

import com.training.content.employee.application.mapper.EmployeeMapper;
import com.training.content.employee.domain.entity.Employee;
import com.training.content.employee.domain.repository.GetEmployeeRepository;
import com.training.content.employee.infrastructure.repository.jpa.EmployeeRepositoryJpa;
import com.training.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GetEmployeeRepositoryImpl implements GetEmployeeRepository {

    private final EmployeeRepositoryJpa repoJpa;

    private final EmployeeMapper mapper;

    @Override
    public Employee getById(Integer id) {

        EmployeeJpa employeeJpa = repoJpa.getReferenceById(id);

        return mapper.jpaToDomain(employeeJpa);
    }

    @Override
    public List<Employee> getAll(String department, String category) {
        List<EmployeeJpa> employeeJpaList = repoJpa.findAllByDepartmentAndCategory(department, category);

        return employeeJpaList.stream()
                .map(mapper::jpaToDomain)
                .collect(Collectors.toList());
    }
}
