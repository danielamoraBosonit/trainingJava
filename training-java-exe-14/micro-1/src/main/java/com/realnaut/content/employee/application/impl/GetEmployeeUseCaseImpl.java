package com.realnaut.content.employee.application.impl;

import com.realnaut.content.employee.application.GetEmployeeUseCase;
import com.realnaut.content.employee.domain.entity.Employee;
import com.realnaut.content.employee.domain.repository.GetEmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class GetEmployeeUseCaseImpl implements GetEmployeeUseCase {

    public static final String ONLINE = "ONLINE";
    public static final String OFFLINE = "OFFLINE";

    private final GetEmployeeRepository repo;

    @Override
    public Employee getById(Integer id){

        return repo.getById(id);
    }


    @Override
    public List<Employee> getAll(String department, String category){

        return repo.getAll(department, category);
    }

    @Override
    public List<Employee> getByState(String state) {

        boolean onlineState = state.equalsIgnoreCase(ONLINE);
        boolean offlineState = state.equalsIgnoreCase(OFFLINE);

        if (onlineState) {
            return repo.getOnlineState(true);

        } else if (offlineState) {
            return repo.getOnlineState(false);

        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Employee getByEmail(String email){

        return repo.getByEmail(email);
    }

}
