package com.mediquity.employee.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediquity.employee.bean.Employee;
import com.mediquity.employee.dto.EmployeeDTO;
import com.mediquity.employee.exception.ResourceNotFoundException;
import com.mediquity.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    // @Autowired
    private final EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Spring automatically injects this
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public EmployeeDTO convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public Employee convertToEntity(EmployeeDTO dto) {
        return modelMapper.map(dto, Employee.class);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }
    
    @Override
    public Employee getEmpById(int id) {
        return employeeRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee not found with ID: " + id)
        );
    }

    @Override
    public Employee saveEmp(EmployeeDTO employee) {
        return employeeRepo.saveAndFlush(this.convertToEntity(employee));
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
