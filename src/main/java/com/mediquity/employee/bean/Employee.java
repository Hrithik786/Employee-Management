package com.mediquity.employee.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.mediquity.employee.enums.BloodGroup;
import com.mediquity.employee.enums.EmployeeStatus;
import com.mediquity.employee.enums.Gender;
import com.mediquity.employee.enums.Language;
import com.mediquity.employee.enums.MaritalStatus;
import com.mediquity.employee.enums.Nationality;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity(name="employee")
public class Employee {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;
    
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Must be a 10-digit number")
    private String contactNum;

    // @NotNull
    @Enumerated(EnumType.STRING) //By default, enums are stored as ordinal values (0, 1, 2...).
    private EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Min(18)
    @Max(65)
    private int age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @Enumerated(EnumType.STRING)
    @Value("UNKNOWN")
    private BloodGroup bloodGroup;

    @NotNull
    @ElementCollection(targetClass = Language.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "employee_languages")
    @Column(name = "language")
    private List<Language> language;
    
    public Employee() {
        super();
    }

    public Employee(@NotNull int id, @NotBlank String name, @Email String email,
            @NotBlank @Pattern(regexp = "\\d{10}", message = "Must be a 10-digit number") String contactNum,
            EmployeeStatus employeeStatus, MaritalStatus maritalStatus, @NotNull Gender gender,
            @NotNull @Min(18) @Max(65) int age, @NotNull Nationality nationality, BloodGroup bloodGroup,
            @NotNull List<Language> language) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNum = contactNum;
        this.employeeStatus = employeeStatus;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
        this.bloodGroup = bloodGroup;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }
    
}