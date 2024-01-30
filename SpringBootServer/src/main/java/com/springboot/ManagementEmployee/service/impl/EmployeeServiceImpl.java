package com.springboot.ManagementEmployee.service.impl;

import com.springboot.ManagementEmployee.model.Employee;
import com.springboot.ManagementEmployee.repository.EmployeeRepository;
import com.springboot.ManagementEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository EmployeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return EmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> Employees = EmployeeRepository.findAll();
        if (!Employees.isEmpty()) {
            return Employees;
        } else {
            throw new RuntimeException("Không Thành Công");
        }
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Integer id) {
         Employee employee = EmployeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Integer id, Employee employeeDetails) {
        Employee employee = EmployeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        Employee updateEmployee = EmployeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Integer id) {
        Employee employee = EmployeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        EmployeeRepository.delete(employee);
        Map<String,Boolean> respone = new HashMap<>();
        respone.put("deleled",Boolean.TRUE);
        return ResponseEntity.ok(respone);
    }
}
