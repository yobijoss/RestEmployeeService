package com.yobijoss.RestEmployeeService.service;

import com.yobijoss.RestEmployeeService.controller.EmployeeRequestWrapper;
import com.yobijoss.RestEmployeeService.error.EmployeeNotFoundException;
import com.yobijoss.RestEmployeeService.model.Employee;
import com.yobijoss.RestEmployeeService.model.Status;
import com.yobijoss.RestEmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EmployeeService {

    private static final String DATE_TIME_FORMAT = "yyyy-mm-dd";

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee insert(EmployeeRequestWrapper employeeRequestWrapper) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);

        Employee employee = new Employee();
        employee.setDateOfBirth(simpleDateFormat.parse(employeeRequestWrapper.getDateOfBirth()));
        employee.setDateOfEmployment(simpleDateFormat.parse(employeeRequestWrapper.getDateOfEmployment()));
        employee.setFirstName(employeeRequestWrapper.getFirstName());
        employee.setMiddleInitial(employeeRequestWrapper.getMiddleInitial());
        employee.setLastName(employeeRequestWrapper.getLastName());
        employee.setStatus(Status.parseInt(employeeRequestWrapper.getStatus()));
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
