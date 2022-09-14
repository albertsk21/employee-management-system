package com.example.project.repositories;

import com.example.project.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {


    Employee findEmployeeById(Long id);

//    @Query("FROM Employee AS e WHERE e.firstName = :firstName")
    List<Employee> findEmployeeByFirstName(String firstName);
}
