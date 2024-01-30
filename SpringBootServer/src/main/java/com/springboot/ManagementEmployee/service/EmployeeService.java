package com.springboot.ManagementEmployee.service;

import com.springboot.ManagementEmployee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee saveEmployee(Employee Employee);
    public ResponseEntity<Employee> getEmployeeById(Integer id);
    public ResponseEntity<Employee> updateEmployee(Integer id,Employee employee);
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(Integer id);
}
