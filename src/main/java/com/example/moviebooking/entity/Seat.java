package com.example.moviebooking.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Enumerated(EnumType.STRING)
    SeatType seatType;
    @Enumerated(EnumType.STRING)
    SeatCondition seatCondition;
    String RowName;
    Integer seatNumber;
    Integer capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    Booking booking;
}
