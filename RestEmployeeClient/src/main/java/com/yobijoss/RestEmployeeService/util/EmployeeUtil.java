package com.yobijoss.RestEmployeeService.util;

import com.yobijoss.RestEmployeeService.controller.request.PatchEmployeeRequest;
import com.yobijoss.RestEmployeeService.model.Employee;

public class EmployeeUtil {

    public static void updateEmployee(Employee employee, PatchEmployeeRequest pastEmployeeRequest) {

        if (pastEmployeeRequest.getFirstName() != null) {
            employee.setFirstName(pastEmployeeRequest.getFirstName());
        }
        if (pastEmployeeRequest.getMiddleInitial() != null) {
            employee.setMiddleInitial(pastEmployeeRequest.getMiddleInitial());
        }
        if (pastEmployeeRequest.getLastName() != null) {
            employee.setLastName(pastEmployeeRequest.getLastName());
        }
        if (pastEmployeeRequest.getDateOfBirth() != null) {
            employee.setDateOfBirth(pastEmployeeRequest.getDateOfBirth());
        }
        if (pastEmployeeRequest.getDateOfEmployment() != null) {
            employee.setDateOfEmployment(pastEmployeeRequest.getDateOfEmployment());
        }
    }
}
