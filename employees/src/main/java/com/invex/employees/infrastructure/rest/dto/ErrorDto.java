package com.invex.employees.infrastructure.rest.dto;

import java.time.LocalDate;
import java.util.List;

public record ErrorDto(
        List<String> errors,
        LocalDate timestamp
) {
}
