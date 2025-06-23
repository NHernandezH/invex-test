package com.invex.employees.infrastructure.rest.dto;

import com.invex.employees.common.validations.ValidDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static com.invex.employees.common.constants.EmployeeValidationMessage.*;

public record EmployeeDto(

        @NotEmpty(message = FIRST_NAME_NOT_EMPTY)
        @Pattern(regexp = "^[a-zA-Z]+$", message = FIRST_NAME_NOT_VALID)
        String firstName,
        String secondName,

        @NotEmpty(message = PATERNAL_SURNAME_NOT_EMPTY)
        @Pattern(regexp = "^[a-zA-Z]+$", message = PATERNAL_SURNAME_NOT_VALID)
        String paternalSurname,
        String maternalSurname,

        @NotEmpty(message = GENDER_NOT_EMPTY)
        @Pattern(regexp = "^[MFO]$", message = GENDER_NOT_VALID)
        String gender,

        @NotEmpty(message = BIRTHDATE_NOT_EMPTY)
        @ValidDate(message = BIRTHDATE_FORMAT_NOT_VALID)
        String birthdate,

        @NotEmpty(message = POSITION_NOT_EMPTY)
        String position
) {
}
