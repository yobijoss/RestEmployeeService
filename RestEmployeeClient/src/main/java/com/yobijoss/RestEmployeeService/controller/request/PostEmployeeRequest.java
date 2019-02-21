package com.yobijoss.RestEmployeeService.controller.request;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class PostEmployeeRequest {

    @NotNull
    @Size(min = 1, max = 128, message = "firstName should not be empty")
    String firstName;

    @Size(min = 1, max = 1, message = "Middle Initial should be one letter")
    String middleInitial;

    @NotNull
    @Size(min = 1, max = 128, message = "lastName should not be empty")
    String lastName;

    @NotNull
    Date dateOfBirth;

    @NotNull
    Date dateOfEmployment;
}
