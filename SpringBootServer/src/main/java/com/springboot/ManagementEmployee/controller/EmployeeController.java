package com.springboot.ManagementEmployee.controller;


import com.springboot.ManagementEmployee.model.Employee;
import com.springboot.ManagementEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;


    //Get All Employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return EmployeeService.getAllEmployees();
    }

    //Get Employee By Id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        return EmployeeService.getEmployeeById(id);
    }

    //create employee
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee Employee) {
        return EmployeeService.saveEmployee(Employee);
    }

    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
        return EmployeeService.updateEmployee(id,employee);
    }

    //delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
        return EmployeeService.deleteEmployee(id);
    }
}
