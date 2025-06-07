package com.mediquity.employee.enums;

public enum Gender {
    MALE("Male", "M"),
    FEMALE("Female", "F"),
    PREFER_NOT_TO_SAY("Other", "O");
    
    private final String displayName;
    private final String code;
    
    Gender(String displayName, String code) {
        this.displayName = displayName;
        this.code = code;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public String getCode() {
        return code;
    }
}