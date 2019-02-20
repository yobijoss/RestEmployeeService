package com.yobijoss.RestEmployeeService.controller.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PostEmployeeRequest {

    @NotBlank
    @Size(min = 1, max = 128, message = "firstName should not be empty")
    String firstName;

    @Size(min = 1, max = 1)
    String middleInitial;

    @NotBlank
    @Size(min = 1, max = 128, message = "lastName should not be empty")
    String lastName;

    @NotEmpty
    String dateOfBirth;
    @NotEmpty
    String dateOfEmployment;

}
