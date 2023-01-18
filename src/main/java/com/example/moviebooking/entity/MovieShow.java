package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MOVIESHOW")
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date date;
    Time time;

    @Enumerated(EnumType.STRING)
    StratergyType stratergyType;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    private Theatre theatre;
    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movieshow_id")
    private Set<Booking> bookings;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movieshow_id")
    private Set<SeatPrice> seatPrices;
}
