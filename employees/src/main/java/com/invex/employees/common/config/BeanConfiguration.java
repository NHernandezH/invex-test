package com.invex.employees.common.config;

import com.invex.employees.application.service.EmployeeSearchService;
import com.invex.employees.application.service.EmployeeStorageService;
import com.invex.employees.domain.port.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public EmployeeStorageService employeeStorageService(EmployeeRepository repository) {
        return new EmployeeStorageService(repository);
    }

    @Bean
    public EmployeeSearchService employeeSearchService(EmployeeRepository repository) {
        return new EmployeeSearchService(repository);
    }
}
