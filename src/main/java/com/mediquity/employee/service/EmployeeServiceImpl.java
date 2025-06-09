package com.mediquity.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediquity.employee.bean.Employee;
import com.mediquity.employee.config.EmployeeMapper;
import com.mediquity.employee.dto.EmployeeDTO;
import com.mediquity.employee.enums.EmployeeStatus;
import com.mediquity.employee.repository.EmployeeRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    // @Autowired
    private final EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    // Spring automatically injects this
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream()
        .filter(emp ->  emp.getEmployeeStatus() == null || emp.getEmployeeStatus() == EmployeeStatus.ACTIVE)
        .map(employeeMapper::convertToDto)
        .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmpById(int id) {
        return employeeMapper.convertToDto(employeeRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id))
        );
    }

    @Override
    public Employee saveEmp(EmployeeDTO employee) {
        return employeeRepo.saveAndFlush(employeeMapper.convertToEntity(employee));
    }

    @Override
    public String deleteEmp(int id) {
        Optional<Employee> optionalEmp = employeeRepo.findById(id);
        if (optionalEmp.isPresent()) {
            Employee employee = optionalEmp.get();
            employee.setEmployeeStatus(EmployeeStatus.INACTIVE);
            employeeRepo.save(employee);
            return "deleted_successfully";
        } else {
            throw new EntityNotFoundException("Employee with ID " + id + " not found.");
        }
    }

    @Override
    public void updateEmp(EmployeeDTO emp) {
        employeeRepo.saveAndFlush(employeeMapper.convertToEntity(emp));
    }
}
