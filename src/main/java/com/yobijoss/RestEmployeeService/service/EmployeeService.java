package com.yobijoss.RestEmployeeService.service;

import com.yobijoss.RestEmployeeService.error.EmployeeNotFoundException;
import com.yobijoss.RestEmployeeService.model.Employee;
import com.yobijoss.RestEmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException(id);
        }
        return employee.get();
    }

}
