package com.example.exceptions.dto;

public enum Genre {
    MR("mr."),
    MRS("mrs."),
    MS("mss.");

    private final String label;

    Genre(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
