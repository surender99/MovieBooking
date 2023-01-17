package com.example.moviebooking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SCREEN")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String screenName;
    int capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    Theatre theatre;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "screen_id")
    Set<Show> shows;
}

