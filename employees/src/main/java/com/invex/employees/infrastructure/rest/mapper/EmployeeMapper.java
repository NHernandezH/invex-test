package com.invex.employees.infrastructure.rest.mapper;

import com.invex.employees.common.constants.DateFormats;
import com.invex.employees.domain.model.Employee;
import com.invex.employees.infrastructure.rest.dto.EmployeeCreatedDto;
import com.invex.employees.infrastructure.rest.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);



    List<Employee> toEmployees(List<EmployeeDto> employees);

    @Mapping(source = "birthdate", target = "birthdate", dateFormat = DateFormats.DD_MM_YYYY)
    Employee toEmployee(EmployeeDto employee);

    @Mapping(source = "employee.birthdate", target = "birthdate", dateFormat = DateFormats.DD_MM_YYYY)
    @Mapping(source = "id", target = "id")
    Employee toEmployee(EmployeeDto employee, Long id);

    List<EmployeeCreatedDto> toEmployeesCreatedDto(List<Employee> employees);

    @Mapping(source = "active", target = "status", qualifiedByName = "mapStatus")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "mapGender")
    @Mapping(source = "birthdate", target = "birthdate", dateFormat = DateFormats.DD_MM_YYYY)
    EmployeeCreatedDto toEmployeesCreatedDto(Employee employee);

    @Named("mapStatus")
    default String mapStatus(Boolean status) {
        if (status == null) return null;
        return status ? "Activo" : "Inactivo";
    }

    @Named("mapGender")
    default String mapGender(String gender) {
        return switch (gender) {
            case "M" -> "Masculino";
            case "F" -> "Femenino";
            case "O" -> "Otro";
            default -> "No definido";
        };
    }
}
