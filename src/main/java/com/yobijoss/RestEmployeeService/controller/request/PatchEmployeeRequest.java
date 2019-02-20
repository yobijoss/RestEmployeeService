package com.yobijoss.RestEmployeeService.controller.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PatchEmployeeRequest {

    @Size(min = 1, max = 128, message = "firstName should not be empty")
    String firstName;

    String middleInitial;

    @Size(min = 1, max = 128, message = "lastName should not be empty")
    String lastName;

    @NotEmpty
    String dateOfBirth;
    @NotEmpty
    String dateOfEmployment;

    @Min(0)
    @Max(1)
    @PositiveOrZero(message = "status needs to be declared (0 = INACTIVE, 1 = ACTIVE")
    int status;

}
