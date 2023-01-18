package com.example.moviebooking.util;

import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.entity.*;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiscountStrategy_Afternoon extends DiscountStrategy{
    @Override
    public double calculate(MovieShow movieShow, BookingDetails bookingDetails, Map<SeatType, Integer> seatPriceMap) {
        Time after = Time.valueOf("12:00:00");
        Time before = Time.valueOf("15:00:00");
        List<Seat> seats = bookingDetails.getSeatIds().stream()
                .map(Seat::new)
                .collect(Collectors.toList());

        double amount =0;
        boolean eligibleForDisc = false;
        if(movieShow.getTime().after(after) && movieShow.getTime().before(before)) {
           eligibleForDisc = true;
        }
        for(Seat seat: seats) {
            Integer seatPrice = seatPriceMap.get(seat.getSeatType());
            if(eligibleForDisc)
                seatPrice = (seatPrice * 70)/100;
            amount += seatPrice.intValue();
        }
        return amount;
    }
}
