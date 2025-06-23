package com.invex.employees.application.usecases;

import com.invex.employees.domain.model.Employee;
import com.invex.employees.domain.model.Paging;

import java.util.List;

public interface EmployeeSearch {

    Employee byId(Long id);
    List<Employee> all(Paging paging);

    List<Employee> byName(String name, Paging paging);


}
