package com.mediquity.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.mediquity.employee.bean.Employee;
import com.mediquity.employee.dto.EmployeeDTO;
import com.mediquity.employee.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "home"; // View: home.html
    }

    @GetMapping("/employee/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee-form";
    }
    
    @GetMapping("/employee/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmpById(id));
        return "edit-employee-form";
    }

    @PostMapping("/employee")
    public String createEmp(@ModelAttribute("employee") @Valid EmployeeDTO emp,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "add-employee-form";
        }
        employeeService.saveEmp(emp);
        return "redirect:/home";
    }

    @PostMapping("/employee/update/{id}")
    public String updateEmployee(@PathVariable("id") int id,
                                 @ModelAttribute("employee") @Valid EmployeeDTO emp,
                                 BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result);
            return "edit-employee-form";
        }
        emp.setId(id);
        employeeService.updateEmp(emp);
        return "redirect:/home";
    }
    @PostMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmp(id);
        return "redirect:/home";
    }
}  