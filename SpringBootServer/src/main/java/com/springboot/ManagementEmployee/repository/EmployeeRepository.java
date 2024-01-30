package com.springboot.ManagementEmployee.repository;
import com.springboot.ManagementEmployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
