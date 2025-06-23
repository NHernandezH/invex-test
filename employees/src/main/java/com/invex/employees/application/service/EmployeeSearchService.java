package com.invex.employees.application.service;

import com.invex.employees.application.usecases.EmployeeSearch;
import com.invex.employees.domain.exception.EmployeeNotFoundException;
import com.invex.employees.domain.model.Employee;
import com.invex.employees.domain.model.Paging;
import com.invex.employees.domain.port.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeSearchService implements EmployeeSearch {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee byId(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public List<Employee> all(Paging paging) {
        return employeeRepository.findAll(paging);
    }

    @Override
    public List<Employee> byName(String name, Paging paging) {
        return employeeRepository.findByName(name, paging);
    }
}
