package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHOWBOOKING")
public class ShowBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id")
    private Set<Booking> bookings;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id")
    private Set<SeatPrice> seatPrices;
}
