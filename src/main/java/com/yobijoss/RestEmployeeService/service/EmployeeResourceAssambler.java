package com.yobijoss.RestEmployeeService.service;

import com.yobijoss.RestEmployeeService.controller.EmployeeServiceController;
import com.yobijoss.RestEmployeeService.error.EmployeeNotFoundException;
import com.yobijoss.RestEmployeeService.model.Employee;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class EmployeeResourceAssambler implements ResourceAssembler<Employee, Resource<Employee>> {

    @Override
    public Resource<Employee> toResource(Employee entity) {
        List<Link> list = new ArrayList<>();
        list.add(getEmployeeLink(entity));
        list.add(getEmployeesLink());
        return new Resource<>(entity, list);
    }

    private Link getEmployeeLink(Employee employee) {
        Link link;
        try {
            link = linkTo(methodOn(EmployeeServiceController.class).findEmployeeById(employee.getId())).withSelfRel();
            return link;
        } catch (EmployeeNotFoundException e) {
            link = new Link("");
        }
        return link;
    }

    private Link getEmployeesLink() {
        return linkTo(methodOn(EmployeeServiceController.class).getAll()).withRel("employee");
    }
}
