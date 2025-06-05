package com.mediquity.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediquity.employee.bean.Employee;

public interface EmployeeRepo extends JpaRepository< Employee, Integer> {
}