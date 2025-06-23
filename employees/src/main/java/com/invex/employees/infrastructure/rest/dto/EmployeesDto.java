package com.invex.employees.infrastructure.rest.dto;

import com.invex.employees.common.constants.EmployeeValidationMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

import static com.invex.employees.common.constants.EmployeeValidationMessage.*;


@Getter
@Setter
public class EmployeesDto {

    @Valid
    @NotEmpty(message = EMPLOYEES_LIST_NOT_EMPTY)
    List<EmployeeDto> employees;
}
