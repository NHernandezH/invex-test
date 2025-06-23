package com.invex.employees.infrastructure.rest.dto;

import java.util.Date;

public record EmployeeCreatedDto (

    Long id,
    String firstName,
    String lastName,
    String paternalSurname,
    String maternalSurname,
    Integer age,
    String gender,
    String birthdate,
    String position,
    String registerDate,
    String status
){ }
