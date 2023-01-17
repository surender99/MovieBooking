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
@Table(name = "SHOW")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date date;
    Time time;

    StratergyType stratergyType;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    private Theatre theatre;
    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;
    @OneToOne(cascade = CascadeType.ALL)
    private ShowBooking showBooking;
}
