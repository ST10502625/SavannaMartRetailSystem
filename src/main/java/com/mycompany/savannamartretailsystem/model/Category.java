package com.mycompany.savannamartretailsystem.model;

public enum Category {
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    GROCERIES("Groceries");

    private final String displayName;
    Category(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}