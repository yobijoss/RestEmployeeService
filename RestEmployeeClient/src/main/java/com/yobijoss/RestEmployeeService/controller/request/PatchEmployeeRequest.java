package com.yobijoss.RestEmployeeService.controller.request;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class PatchEmployeeRequest {

    @Size(min = 1, max = 128, message = "firstName should not be empty")
    String firstName;

    @Size(min = 1, max = 1, message = "middle initial should be one letter")
    String middleInitial;

    @Size(min = 1, max = 128, message = "lastName should not be empty")
    String lastName;

    Date dateOfBirth;
    Date dateOfEmployment;
}
