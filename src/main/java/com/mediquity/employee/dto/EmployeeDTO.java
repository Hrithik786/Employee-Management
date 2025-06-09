package com.mediquity.employee.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.mediquity.employee.enums.BloodGroup;
import com.mediquity.employee.enums.Gender;
import com.mediquity.employee.enums.MaritalStatus;
import com.mediquity.employee.enums.Nationality;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import com.mediquity.employee.enums.Language;

public class EmployeeDTO {
    
    @NotBlank
    private String name;
    
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Must be a 10-digit number")
    private String contactNum;
    
    @NotNull
    private Gender gender;
    
    @NotNull
    @Min(18)
    @Max(65)
    private int age;
    
    @NotNull
    private MaritalStatus maritalStatus;

    @NotEmpty
    private List<Language> language;

    @NotNull
    private Nationality nationality;

    @Value("UNKNOWN")
    private BloodGroup bloodGroup;

    public EmployeeDTO() {
        super();
    }
    public EmployeeDTO(String name, String email, String contactNum, Gender gender,
                       MaritalStatus maritalStatus, int age, Nationality nationality,
                       List<Language> language, BloodGroup bloodGroup) {
        this.name = name;
        this.email = email;
        this.contactNum = contactNum;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.age = age;
        this.nationality = nationality;
        this.language = language;
        this.bloodGroup = bloodGroup;
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
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public List<Language> getLanguage() {
        return language;
    }
    public void setLanguage(List<Language> language) {
        this.language = language;
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
    @Override
    public String toString() {
        return "EmployeeDTO [name=" + name + ", email=" + email + ", contactNum=" + contactNum + ", gender=" + gender
                + ", age=" + age + ", maritalStatus=" + maritalStatus + ", language=" + language + ", nationality="
                + nationality + ", bloodGroup=" + bloodGroup + ", getName()=" + getName() + ", getEmail()=" + getEmail()
                + ", getContactNum()=" + getContactNum() + ", getGender()=" + getGender() + ", getAge()=" + getAge()
                + ", getMaritalStatus()=" + getMaritalStatus() + ", getLanguage()=" + getLanguage()
                + ", getNationality()=" + getNationality() + ", getBloodGroup()=" + getBloodGroup() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
    
}
