package com.invex.employees.domain.exception;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends RuntimeException{

    private Long id;

    public EmployeeNotFoundException(Long id){
        super(String.format("User with id:%d not found",id));
        this.id = id;
    }
}
