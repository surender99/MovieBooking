package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double amount;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    Set<Seat> seats;
    @OneToOne(cascade = CascadeType.ALL)
    Payment payment;
    @ManyToOne(fetch = FetchType.LAZY)
    MovieShow movieShow;
}
