package com.mediquity.employee.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Must be a 10-digit number")
    private String contactNum;

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setContactNum(String contactNum){
        this.contactNum = contactNum;
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getContactNum(){
        return contactNum;
    }

    @Override
    public String toString() {
        return "id: " + id + " "+ name + " " + email + " " + contactNum;
    }
}