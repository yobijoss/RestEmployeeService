package com.yobijoss.RestEmployeeService.service;

import com.yobijoss.RestEmployeeService.controller.request.PatchEmployeeRequest;
import com.yobijoss.RestEmployeeService.controller.request.PostEmployeeRequest;
import com.yobijoss.RestEmployeeService.error.EmployeeNotFoundException;
import com.yobijoss.RestEmployeeService.model.Employee;
import com.yobijoss.RestEmployeeService.model.Status;
import com.yobijoss.RestEmployeeService.repository.EmployeeRepository;
import com.yobijoss.RestEmployeeService.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        if (employee.getStatus() == Status.INACTIVE) {
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }

    public Employee insert(PostEmployeeRequest postEmployeeRequest) {
        Employee employee = new Employee();
        employee.setDateOfBirth(postEmployeeRequest.getDateOfBirth());
        employee.setDateOfEmployment(postEmployeeRequest.getDateOfEmployment());
        employee.setFirstName(postEmployeeRequest.getFirstName());
        employee.setMiddleInitial(postEmployeeRequest.getMiddleInitial());
        employee.setLastName(postEmployeeRequest.getLastName());
        employee.setStatus(Status.ACTIVE);
        return employeeRepository.save(employee);
    }

    public Employee delete(Long id) throws EmployeeNotFoundException {
        Employee employee = findById(id);
        employee.setStatus(Status.INACTIVE);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findByStatus(Status.ACTIVE);
    }

    public Employee update(Long id, PatchEmployeeRequest patchEmployeeRequest) throws EmployeeNotFoundException {
        Employee employee = findById(id);
        EmployeeUtil.updateEmployee(employee, patchEmployeeRequest);
        return employeeRepository.save(employee);
    }
}
