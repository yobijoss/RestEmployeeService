package com.yobijoss.RestEmployeeService.controller;

import com.yobijoss.RestEmployeeService.controller.request.PatchEmployeeRequest;
import com.yobijoss.RestEmployeeService.controller.request.PostEmployeeRequest;
import com.yobijoss.RestEmployeeService.error.EmployeeNotFoundException;
import com.yobijoss.RestEmployeeService.model.Employee;
import com.yobijoss.RestEmployeeService.service.EmployeeResourceAssambler;
import com.yobijoss.RestEmployeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/employee")
public class EmployeeServiceController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeResourceAssambler employeeResourceAssambler;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Resource<Employee>> findEmployeeById(@PathVariable(value = "id") Long id) throws EmployeeNotFoundException {
        Resource<Employee> employeeResource = employeeResourceAssambler.toResource(employeeService.findById(id));
        return new ResponseEntity<>(employeeResource, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Resource<Employee>>> getAll() {
        List<Resource<Employee>> employees = employeeService.getAll().stream()
                .map(employee -> employeeResourceAssambler.toResource(employee))
                .collect(Collectors.toList());
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Resource<Employee>> createEmployee(@Valid @RequestBody PostEmployeeRequest postEmployeeRequest) throws ParseException {
        Employee employee = employeeService.insert(postEmployeeRequest);
        return new ResponseEntity<>(employeeResourceAssambler.toResource(employee), HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Resource<Employee>> updateEmploye(@PathVariable(value = "id") Long id, @RequestBody PatchEmployeeRequest patchEmployeeRequest)
            throws ParseException, EmployeeNotFoundException {
        Employee employee = employeeService.update(id, patchEmployeeRequest);
        return new ResponseEntity<>(employeeResourceAssambler.toResource(employee), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteEmployees(@PathVariable(value = "id") Long id) throws EmployeeNotFoundException {
        Employee employee = employeeService.delete(id);
        return new ResponseEntity<>("Employee with id:" + employee.getId() + " has been deleted", HttpStatus.OK);
    }

    @ExceptionHandler({EmployeeNotFoundException.class})
    public Map<String, Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        Map<String, Object> errorAttributes = new HashMap<>(1);
        errorAttributes.put("errorMsg", ex.getMessage());
        return errorAttributes;
    }

    @ExceptionHandler({ParseException.class})
    public Map<String, Object> handleParseExceptionException(EmployeeNotFoundException ex) {
        Map<String, Object> errorAttributes = new HashMap<>(1);
        errorAttributes.put("errorMsg", ex.getMessage());
        return errorAttributes;
    }
}
