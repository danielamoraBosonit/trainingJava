package com.realnaut.content.employee.application.impl;

import com.realnaut.content.employee.application.GetEmployeeUseCase;
import com.realnaut.content.employee.domain.entity.Employee;
import com.realnaut.content.employee.domain.repository.GetEmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class GetEmployeeUseCaseImpl implements GetEmployeeUseCase {

    private final GetEmployeeRepository repo;


    @Override
    public Employee getById(Integer id){

        return repo.getById(id);
    }


    @Override
    public List<Employee> getAll(String department, String category){

        return repo.getAll(department, category);
    }

}
