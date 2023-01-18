package com.example.moviebooking.repository;

import com.example.moviebooking.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<MovieShow, Integer> {
}
