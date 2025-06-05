package com.mediquity.employee.service;

import java.util.List;

import com.mediquity.employee.bean.Employee;

public interface EmployeeService {
    
    List<Employee> getAllEmployee();
    Employee getEmpById(int id);
    Employee saveEmp(Employee employee);
    String deleteEmp(int id);
}