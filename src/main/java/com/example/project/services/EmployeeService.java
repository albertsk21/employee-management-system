package com.example.project.services;

import com.example.project.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    List<Employee> getEmployeesByFirstName(String firstName);
}
