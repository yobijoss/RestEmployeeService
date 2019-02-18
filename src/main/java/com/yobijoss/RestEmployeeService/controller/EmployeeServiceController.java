package com.yobijoss.RestEmployeeService.controller;

import com.yobijoss.RestEmployeeService.error.EmployeeNotFoundException;
import com.yobijoss.RestEmployeeService.model.Employee;
import com.yobijoss.RestEmployeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class EmployeeServiceController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
    public Employee findEmployeeById(@PathVariable(value = "id") Long id) throws EmployeeNotFoundException {
        return employeeService.findById(id);
    }

    @ExceptionHandler({EmployeeNotFoundException.class})
    public Map<String, Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        Map<String, Object> errorAttributes = new HashMap<>(1);
        errorAttributes.put("errorMsg", ex.getMessage());
        return errorAttributes;
    }
}
