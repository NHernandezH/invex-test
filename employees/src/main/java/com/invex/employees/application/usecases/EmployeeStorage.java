package com.invex.employees.application.usecases;

import com.invex.employees.domain.model.Employee;

import java.util.List;

public interface EmployeeStorage {

    List<Employee> saveAll(List<Employee> employees);

    void update(Employee employee);

    void delete(Long id);
}
