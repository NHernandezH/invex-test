package com.invex.employees.infrastructure.repository.mapper;

import com.invex.employees.domain.model.Employee;
import com.invex.employees.infrastructure.repository.entity.EmployeeEntity;
import com.invex.employees.infrastructure.rest.dto.EmployeeDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    List<EmployeeEntity> toEmployeeEntity(List<Employee> employees);

    @Mapping(source = "active", target = "active", qualifiedByName = "defaultTrue")
    EmployeeEntity toEmployeeEntity(Employee employee);

    @Named("defaultTrue")
    default Boolean defaultTrue(Boolean value) {
        return value !=null? value: true;
    }

    List<Employee> toEmployee(List<EmployeeEntity> employees);

    Employee toEmployee(EmployeeEntity employees);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromEmployee(Employee employee, @MappingTarget EmployeeEntity employeeEntity);
}
