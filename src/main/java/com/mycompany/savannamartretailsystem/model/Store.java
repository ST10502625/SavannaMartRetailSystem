package com.mycompany.savannamartretailsystem.model;

public enum Store {
    CAPE_TOWN("Cape Town"),
    DURBAN("Durban"),
    JOHANNESBURG("Johannesburg"),
    BLOEMFONTEIN("Bloemfontein");

    private final String displayName;
    Store(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}