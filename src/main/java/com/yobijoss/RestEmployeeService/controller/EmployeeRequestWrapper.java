package com.yobijoss.RestEmployeeService.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeRequestWrapper {
    @NotEmpty
    String firstName;

    String middleInitial;
    String lastName;

    @NotEmpty
    String dateOfBirth;
    @NotEmpty
    String dateOfEmployment;

    @NotNull
    int status;

}
