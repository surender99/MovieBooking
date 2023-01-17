package com.example.moviebooking.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingDetails {
    int showId;
    List<Integer> seatIds;
    String coupon;
}
