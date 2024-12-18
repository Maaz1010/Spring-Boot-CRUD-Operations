package com.springBootProject.service;

import java.util.List;

import com.springBootProject.Employee;
//import com.springBootProject.Entity.EmployeeEntity;

public interface EmployeeService {
    String createEmployee(Employee employee);
    Employee readEmployee(Long id);
    List<Employee> readEmployees();
    String updateEmployee(long id, Employee employee);
    boolean deleteEmployee(long id);

}
