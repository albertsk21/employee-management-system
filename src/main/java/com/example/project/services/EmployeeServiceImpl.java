package com.example.project.services;


import com.example.project.entities.Employee;
import com.example.project.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee existentEmployee = this.getEmployeeById(employee.getId());
        existentEmployee.setFirstName(employee.getFirstName());
        existentEmployee.setLastName(employee.getLastName());
        existentEmployee.setEmail(employee.getEmail());
        existentEmployee.setDepartment(employee.getDepartment());
        this.saveEmployee(existentEmployee);
    }

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) {
        return this.employeeRepository.findEmployeeByFirstName(firstName);
    }


}
