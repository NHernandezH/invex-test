package com.invex.employees.infrastructure.repository;

import com.invex.employees.domain.model.Employee;
import com.invex.employees.domain.model.Paging;
import com.invex.employees.domain.port.EmployeeRepository;
import com.invex.employees.infrastructure.repository.entity.EmployeeEntity;
import com.invex.employees.infrastructure.repository.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OracleEmployeeRepository implements EmployeeRepository {

    private final EmployeeJpaRepository employeeJpaRepository;

    private final EmployeeMapper employeeMapper= EmployeeMapper.INSTANCE;
    @Override
    public Optional<Employee> findById(Long id) {
        EmployeeEntity employee = employeeJpaRepository.findById(id)
                .orElse(null);

        if(employee == null){
            return Optional.empty();
        }

        return Optional.of(employeeMapper.toEmployee(employee));
    }

    @Override
    public List<Employee> findAll(Paging paging) {
        Pageable pageable = PageRequest.of(paging.page(), paging.size());
        Page<EmployeeEntity> employees = employeeJpaRepository.findAll(pageable);
        return employeeMapper.toEmployee(employees.getContent());
    }

    @Override
    public List<Employee> findByName(String name, Paging paging) {
        return null;
    }

    @Override
    public List<Employee> saveAll(List<Employee> employees) {
        List<EmployeeEntity> employeeEntities = employeeMapper.toEmployeeEntity(employees);
        employeeEntities = employeeJpaRepository.saveAll(employeeEntities);
        return employeeMapper.toEmployee(employeeEntities);
    }

    @Override
    public void update(Employee employee) {
        EmployeeEntity employeeEntity = employeeJpaRepository.findById(employee.getId())
                .orElse(null);
        if(Objects.nonNull(employeeEntity)){
            employeeMapper.updateEntityFromEmployee(employee, employeeEntity);
            employeeJpaRepository.save(employeeEntity);
        }

    }

    @Override
    public void delete(Long id) {

    }
}
