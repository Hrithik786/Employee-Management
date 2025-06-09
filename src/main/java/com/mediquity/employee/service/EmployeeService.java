package com.mediquity.employee.service;

import java.util.List;

import com.mediquity.employee.bean.Employee;
import com.mediquity.employee.dto.EmployeeDTO;

public interface EmployeeService {
    
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmpById(int id);
    Employee saveEmp(EmployeeDTO emp);
    String deleteEmp(int id);
    void updateEmp(EmployeeDTO emp);
}