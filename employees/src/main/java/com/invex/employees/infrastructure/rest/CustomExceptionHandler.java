package com.invex.employees.infrastructure.rest;

import com.invex.employees.domain.exception.EmployeeNotFoundException;
import com.invex.employees.infrastructure.rest.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map((e)->String.format("campo %s : %s",e.getField(),e.getDefaultMessage()))
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(errors, LocalDate.now()));
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return ResponseEntity
                .badRequest()
                .body(createError(ex));
    }


    private ErrorDto createError(Exception ex){
        return new ErrorDto(Collections.singletonList(ex.getMessage()), LocalDate.now());
    }

}
