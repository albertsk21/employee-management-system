package com.example.project.controllers;

import com.example.project.entities.Employee;
import com.example.project.services.EmployeeService;
import com.example.project.utils.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public String getEmployees(Model model){
        List<Employee> employees = this.employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "index";
    }

    @GetMapping("/create")
    public String createEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create-employee";
    }

    @PostMapping("")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        this.employeeService.saveEmployee(employee);
        System.out.println(employee.getEmail());
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model){
        model.addAttribute("employee",this.employeeService.getEmployeeById(id));
        return "edit-employee";
    }
    @PostMapping("/edit/{id}")
    public String postEditEmployee(@PathVariable Long id,@ModelAttribute Employee employee, Model model){
        Employee  existentEmployee = this.employeeService.getEmployeeById(id);
        existentEmployee.setFirstName(employee.getFirstName());
        existentEmployee.setLastName(employee.getLastName());
        existentEmployee.setEmail(employee.getEmail());
        existentEmployee.setDepartment(employee.getDepartment());
        this.employeeService.saveEmployee(existentEmployee);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
    @GetMapping("search")
    public String searchEmployee(@ModelAttribute SearchForm searchForm, Model model){
        model.addAttribute("employees",null);
        return "search";
    }
    @PostMapping("/search")
    public String addDataSearch( Model model,@ModelAttribute("searchForm") SearchForm searchForm, BindingResult bindingResult){
        List<Employee> employees = this.employeeService.getEmployeesByFirstName(searchForm.getData());

        model.addAttribute("employees",employees);
        return "search";
    }
}
