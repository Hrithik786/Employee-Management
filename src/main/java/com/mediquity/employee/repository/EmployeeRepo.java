package com.mediquity.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mediquity.employee.bean.Employee;
import com.mediquity.employee.enums.BloodGroup;
import com.mediquity.employee.enums.Gender;
import com.mediquity.employee.enums.MaritalStatus;
import com.mediquity.employee.enums.Nationality;

public interface EmployeeRepo extends JpaRepository< Employee, Integer> {
    
    List<Employee> findByGender(Gender gender);
    List<Employee> findByMaritalStatus(MaritalStatus maritalStatus);
    List<Employee> findByGenderAndMaritalStatus(Gender gender, MaritalStatus maritalStatus);
    List<Employee> findByNationality(Nationality nationality);
        
    @Query("SELECT u FROM employee u WHERE u.gender = :gender AND u.maritalStatus = :status")
    List<Employee> findUsersByGenderAndStatus(@Param("gender") Gender gender, 
                                         @Param("status") MaritalStatus status);

    @Query("SELECT u FROM employee u WHERE u.gender = :gender AND u.maritalStatus = :status")
    List<Employee> findEmployeesByGenderAndStatus(@Param("gender") Gender gender, 
                                         @Param("status") MaritalStatus status);

    // Custom query to find by country code
    @Query("SELECT u FROM employee u WHERE u.nationality = :nationality")
    List<Employee> findByCountryCode(@Param("nationality") Nationality nationality);

    List<Employee> findByBloodGroup(BloodGroup bloodGroup);
    List<Employee> findByBloodGroupIn(List<BloodGroup> bloodGroups);
    List<Employee> findByBloodGroupIsNotNull();
    List<Employee> findByBloodGroupIsNull();
}