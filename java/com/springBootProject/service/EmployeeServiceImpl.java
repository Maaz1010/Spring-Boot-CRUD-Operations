package com.springBootProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootProject.Employee;
import com.springBootProject.Entity.EmployeeEntity;
import com.springBootProject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    //List<Employee> employeesList = new ArrayList<>();


    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        return "Employee Saved Succesfully";
    }

    @Override
    public List<Employee> readEmployees() {
      List<EmployeeEntity> employeesList =  employeeRepository.findAll();
      List<Employee> employees = new ArrayList<>();

      for (EmployeeEntity employeeEntity : employeesList) {
        Employee emp = new Employee();
        // emp.setId(employeeEntity.getId());
        // emp.setName(employeeEntity.getName());
        // emp.setPhone(employeeEntity.getPhone());
        // emp.setEmail(employeeEntity.getEmail());

        BeanUtils.copyProperties(employeeEntity, emp);
       
        employees.add(emp);
      }
      
      return employees;
     }


    @Override
    public Employee readEmployee(Long id) {
        Optional<EmployeeEntity> employeeEntityOpt = employeeRepository.findById(id);

        if (employeeEntityOpt.isEmpty()) {
            throw new RuntimeException("Employee with ID " + id + " not found.");
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntityOpt.get(), employee);
        return employee;
    }

    @Override
    public boolean deleteEmployee(long id) {
        if (!employeeRepository.existsById(id)) {
            return false;
        }

        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public String updateEmployee(long id, Employee employee) {
        Optional<EmployeeEntity> existingEmployeeOpt = employeeRepository.findById(id);

        if (existingEmployeeOpt.isEmpty()) {
            return "Employee with ID " + id + " not found.";
        }

        EmployeeEntity existingEmployee = existingEmployeeOpt.get();
        BeanUtils.copyProperties(employee, existingEmployee, "id"); // Avoid overwriting the ID
        employeeRepository.save(existingEmployee);

        return "Employee updated successfully.";
    }

    //  @Override
    //  public Employee readEmployee(Long id) {
    //     EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
    //     Employee employee = new Employee();
    //     BeanUtils.copyProperties( employeeEntity,employee);
    //     return employee;    
    // }

    // @Override
    // public boolean deleteEmployee(long id) {
    //     EmployeeEntity emp = employeeRepository.findById(id).get();
    //      employeeRepository.delete(emp);
    //    return true;
    // }

    // @Override
    // public String updateEmployee(long id, Employee employee) {
    //     EmployeeEntity oldemp = employeeRepository.findById(id).get();
    //     oldemp.setEmail(employee.getEmail());
    //     oldemp.setName(employee.getName());
    //     oldemp.setPhone(employee.getPhone());
    //     employeeRepository.save(oldemp);
    //     return "Updated";  
    // }


}
