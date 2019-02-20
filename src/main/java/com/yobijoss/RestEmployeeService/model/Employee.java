package com.yobijoss.RestEmployeeService.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "employee")
public @Data class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_initial_name")
    private String middleInitial;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "date_of_employment")
    private Date dateOfEmployment;

    @Enumerated(value = EnumType.ORDINAL)
    private Status status;

}
