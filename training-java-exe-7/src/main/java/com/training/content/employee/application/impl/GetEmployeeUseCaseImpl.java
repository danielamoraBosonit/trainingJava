package com.training.content.employee.application.impl;

import com.training.content.employee.application.GetEmployeeUseCase;
import com.training.content.employee.domain.entity.Employee;
import com.training.content.employee.domain.repository.GetEmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
