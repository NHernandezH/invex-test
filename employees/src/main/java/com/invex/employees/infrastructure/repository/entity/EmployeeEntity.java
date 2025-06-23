package com.invex.employees.infrastructure.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@Getter @Setter
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "paternal_surname")
    private String paternalSurname;

    @Column(name = "maternal_surname")
    private String maternalSurname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private char gender;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "position")
    private String position;

    @Column(name = "register_date")
    @CreationTimestamp
    private Timestamp registerDate;

    @Column(name = "active")
    private Boolean active = true;
}
