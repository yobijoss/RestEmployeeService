package com.yobijoss.RestEmployeeService.error;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(Long employeeId) {
        super("Employee with Id " + employeeId + " does not exist");
    }
}
