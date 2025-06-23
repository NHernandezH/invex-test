package com.invex.employees.application.service;

import com.invex.employees.application.usecases.EmployeeStorage;
import com.invex.employees.domain.exception.EmployeeNotFoundException;
import com.invex.employees.domain.model.Employee;
import com.invex.employees.domain.port.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeStorageService implements EmployeeStorage {

    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> saveAll(List<Employee> employees) {
       return employeeRepository.saveAll(employees);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new EmployeeNotFoundException(employee.getId()));

        employeeRepository.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }
}
