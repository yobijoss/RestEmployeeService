package com.yobijoss.RestEmployeeService.service;

import com.yobijoss.RestEmployeeService.controller.request.PatchEmployeeRequest;
import com.yobijoss.RestEmployeeService.controller.request.PostEmployeeRequest;
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
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        if (employee.getStatus() == Status.INACTIVE) {
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }

    public Employee insert(PostEmployeeRequest postEmployeeRequest) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);

        Employee employee = new Employee();
        employee.setDateOfBirth(simpleDateFormat.parse(postEmployeeRequest.getDateOfBirth()));
        employee.setDateOfEmployment(simpleDateFormat.parse(postEmployeeRequest.getDateOfEmployment()));
        employee.setFirstName(postEmployeeRequest.getFirstName());
        employee.setMiddleInitial(postEmployeeRequest.getMiddleInitial());
        employee.setLastName(postEmployeeRequest.getLastName());
        return employeeRepository.save(employee);
    }

    public Employee delete(Long id) throws EmployeeNotFoundException {
        Employee employee = findById(id);
        employee.setStatus(Status.INACTIVE);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee update(Long id, PatchEmployeeRequest postEmployeeRequest) throws EmployeeNotFoundException {
        Employee employee = findById(id);

        return employeeRepository.save(employee);
    }
}
