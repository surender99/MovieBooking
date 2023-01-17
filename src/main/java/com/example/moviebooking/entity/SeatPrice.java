package com.example.moviebooking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SEATPRICE")
public class SeatPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    SeatType seatType;
    int price;

    @ManyToOne(fetch = FetchType.LAZY)
    ShowBooking showBooking;
}