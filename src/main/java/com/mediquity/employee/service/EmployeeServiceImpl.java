package com.mediquity.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediquity.employee.bean.Employee;
import com.mediquity.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }
    
    @Override
    public Employee getEmpById(int id) {
        return employeeRepo.getReferenceById(id);
    }

    @Override
    public Employee saveEmp(Employee employee) {
        return employeeRepo.saveAndFlush(employee);
    }

    @Override
    public String deleteEmp(int id) {
        boolean isDeleted=false;
        if (id == '0') {
            return "ID/email is 0 we can't delete it";
        }
        if (!isDeleted) {
            employeeRepo.deleteById(id);
            isDeleted = true;
            return "deleted_successfully";
        }
        return "not_deleted";
    }
    
}
