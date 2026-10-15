package com.springBootProject.service;

import java.util.ArrayList;
import java.util.List;

import com.springBootProject.exception.EmployeeNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootProject.Employee;
import com.springBootProject.entity.EmployeeEntity;
import com.springBootProject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    //List<Employee> employeesList = new ArrayList<>();


    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity, "id"); // ignore any id sent by the client
        EmployeeEntity saved = employeeRepository.save(entity);

        Employee result = new Employee();
        BeanUtils.copyProperties(saved, result);
        return result;
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity entity = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        Employee employee = new Employee();
        BeanUtils.copyProperties(entity, employee);
        return employee;
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
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity existing = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        BeanUtils.copyProperties(employee, existing, "id");
        EmployeeEntity saved = employeeRepository.save(existing);

        Employee result = new Employee();
        BeanUtils.copyProperties(saved, result);
        return result;
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }


}
