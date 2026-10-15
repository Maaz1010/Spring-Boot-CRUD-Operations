package com.springBootProject.service;

import java.util.List;

import com.springBootProject.Employee;
//import com.springBootProject.Entity.EmployeeEntity;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee readEmployee(Long id);
    List<Employee> readEmployees();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
