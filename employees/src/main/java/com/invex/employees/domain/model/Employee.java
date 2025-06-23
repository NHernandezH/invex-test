package com.invex.employees.domain.model;

import com.invex.employees.common.constants.DateFormats;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class Employee {

    private Long id;
    private String firstName;
    private String secondName;
    private String paternalSurname;
    private String maternalSurname;
    private Integer age;
    private String gender;
    private LocalDate birthdate;
    private String position;
    private Timestamp registerDate;
    private Boolean active;

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        calculateAge();
    }

    private void calculateAge(){
        LocalDate now = LocalDate.now();
        Period period = Period.between(this.birthdate, now);
        this.age = period.getYears();

    }
}
