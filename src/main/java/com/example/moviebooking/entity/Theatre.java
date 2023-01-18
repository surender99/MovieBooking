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

public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    Address address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    Set<Screen> screens;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    Set<MovieShow> movieShows;
}