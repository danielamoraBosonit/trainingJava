package com.realnaut.content.employee.infrastructure.repository.jpa;

import com.realnaut.content.employee.infrastructure.repository.jpa.entity.EmployeeJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositoryJpa extends JpaRepository<EmployeeJpa, Integer> {
    List<EmployeeJpa> findAllByDepartmentAndCategory(String department, String category);
}
