package com.mediquity.employee.enums;

public enum BloodGroup {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");
    
    private final String displayName;
    
    BloodGroup(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    // Utility method to find by display name
    public static BloodGroup findByDisplayName(String displayName) {
        for (BloodGroup bloodGroup : values()) {
            if (bloodGroup.displayName.equalsIgnoreCase(displayName)) {
                return bloodGroup;
            }
        }
        return null;
    }
    
    // Check if it's a universal donor
    public boolean isUniversalDonor() {
        return this == O_NEGATIVE;
    }
    
    // Check if it's a universal recipient
    public boolean isUniversalRecipient() {
        return this == AB_POSITIVE;
    }
}