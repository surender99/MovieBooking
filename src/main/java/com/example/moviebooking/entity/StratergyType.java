package com.example.moviebooking.entity;

public enum StratergyType {
    AFTERNOON_30("AFTERNOON_30", 30),
    THIRD_TICKET_50("THIRD_TICKET_50", 50);

    private String name;
    private int discount;
    StratergyType(String name, int discount) {
        this.discount = discount;
        this.name = name;
    }
}
