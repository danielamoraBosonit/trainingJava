package com.realnaut.content.employee.infrastructure.repository.impl;

import com.realnaut.content.employee.application.mapper.EmployeeMapper;
import com.realnaut.content.employee.domain.entity.Employee;
import com.realnaut.content.employee.domain.repository.GetEmployeeRepository;
import com.realnaut.content.employee.infrastructure.repository.jpa.EmployeeRepositoryJpa;
import com.realnaut.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
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
        List<EmployeeJpa> employeeJpaList;

        if (department != null && category != null){
            employeeJpaList = repoJpa.findAllByDepartmentAndCategory(department, category);
        } else if (department == null && category != null ){
            employeeJpaList = repoJpa.findAllByCategory(category);
        } else if (department != null){
            employeeJpaList = repoJpa.findAllByDepartment(department);
        } else {
            employeeJpaList = repoJpa.findAll();
        }

        return employeeJpaList.stream()
                .map(mapper::jpaToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getOnlineState(boolean state) {
        List<EmployeeJpa> employeeJpaList = repoJpa.findAllByOnline(state);

        return employeeJpaList.stream()
                .map(mapper::jpaToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee getByEmail(String email) {

        EmployeeJpa employeeJpa = repoJpa.findByEmail(email);

        return mapper.jpaToDomain(employeeJpa);
    }
}
