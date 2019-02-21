package com.yobijoss.RestEmployeeService.repository;

import com.yobijoss.RestEmployeeService.model.Employee;
import com.yobijoss.RestEmployeeService.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(Status status);
}
