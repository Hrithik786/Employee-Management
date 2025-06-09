package com.mediquity.employee.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mediquity.employee.bean.Employee;
import com.mediquity.employee.dto.EmployeeDTO;

@Component
public class EmployeeMapper {

    @Autowired
    private static ModelMapper modelMapper;

    public static EmployeeDTO convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public static Employee convertToEntity(EmployeeDTO dto) {
        return modelMapper.map(dto, Employee.class);
    }
}
