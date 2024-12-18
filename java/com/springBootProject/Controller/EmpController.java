package com.springBootProject.Controller;

//import java.util.ArrayList;
import java.util.List;

import com.springBootProject.Employee;
import com.springBootProject.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class EmpController {
    // EmployeeService employeeService =new EmployeeServiceImpl();
    
    //? Dependcy Injection
    @Autowired
    private EmployeeService employeeService ;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.readEmployee(id);
    }


    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
      
       return employeeService.createEmployee(employee);
         
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
       return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable long id){
        return  employeeService.deleteEmployee(id)? "deleted Succesfully" : "Id not found";

    }
}
