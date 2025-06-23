package com.invex.employees.domain.port;

import com.invex.employees.domain.model.Employee;
import com.invex.employees.domain.model.Paging;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findById(Long id);
    List<Employee> findAll(Paging paging);

    List<Employee> findByName(String name, Paging paging);

    List<Employee> saveAll(List<Employee> employees);

    void update(Employee employee);

    void delete(Long id);
}
