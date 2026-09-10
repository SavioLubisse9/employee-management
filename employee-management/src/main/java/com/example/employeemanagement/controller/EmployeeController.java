package com.example.employeemanagement.controller;


import com.example.employeemanagement.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
    @Controller
    @RequestMapping("/employees")
    public class EmployeeController {

        private List<Employee> employees = new ArrayList<>();
        private int nextId =1;

        public EmployeeController(){
            employees.add(new Employee(1,"James Clear","Mentality",2500.00,"jamesclear@yahoo.com"));
            employees.add(new Employee(2,"Boris Demidovitch","Mathematics",3000,"bdemidovitc@uem.ac.mz")) ;
        }
        
        @GetMapping
        //@ResponseBody 
        //Transportador de dados do Controller para o view
        //Display all the employees
        public String listEmployees(Model model) {
            //Passes the employees list to the view template
            model.addAttribute("employees", employees);
            //Specifies the template to render
            return "employees/list";
            //return "a";
        }
        //show add employees form
        @GetMapping("/add")
        public String showAddForm(Model model){
            model.addAttribute("employee",new Employee());
            return "employees/add";
        }
        @PostMapping("/add")
        //Form submission
        public String addEmployee(@ModelAttribute Employee employee){
            employee.setId(nextId++);
            employees.add(employee);
            //prevents duplicate form submission
            return "redirect:/employees";
        }

    }


