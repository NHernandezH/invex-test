package com.invex.employees.common.validations;

import com.invex.employees.common.constants.DateFormats;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateVaidator implements ConstraintValidator<ValidDate, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return true;

        try {
            LocalDate.parse(value, DateTimeFormatter.ofPattern(DateFormats.DD_MM_YYYY));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
