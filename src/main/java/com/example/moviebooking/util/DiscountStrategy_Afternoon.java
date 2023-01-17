package com.example.moviebooking.util;

import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.entity.*;
import com.example.moviebooking.repository.SeatPriceRepository;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountStrategy_Afternoon extends DiscountStrategy{
    @Override
    public double calculate(Show show, BookingDetails bookingDetails, SeatPriceRepository seatPriceRepository) {
        Time after = Time.valueOf("12:00:00");
        Time before = Time.valueOf("15:00:00");
        List<Seat> seats = bookingDetails.getSeatIds().stream()
                .map(Seat::new)
                .collect(Collectors.toList());

        double amount =0;
        ShowBooking showBooking = show.getShowBooking();
        if(show.getTime().after(after) && show.getTime().before(before)) {
            for(Seat seat: seats) {
                List<SeatPrice> = seatPriceRepository.findByShow();
            }
        }
    }
}
