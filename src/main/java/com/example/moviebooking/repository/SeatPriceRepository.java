package com.example.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.moviebooking.entity.SeatPrice;

public interface SeatPriceRepository extends JpaRepository<SeatPrice, Integer> {
    SeatPrice findByShowId(int id);
}
