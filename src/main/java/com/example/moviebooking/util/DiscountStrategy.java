package com.example.moviebooking.util;

import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.entity.MovieShow;
import com.example.moviebooking.entity.Seat;
import com.example.moviebooking.entity.SeatType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public abstract class DiscountStrategy {
    public boolean isValid(List<Seat> seatIds) {
        for(Seat seat : seatIds) {
            if(seat.getIsAvailable() == false)
                return false;
        }
        return true;
    }

    public abstract double calculate(MovieShow movieShow, BookingDetails bookingDetails, Map<SeatType, Integer> seatPriceMap);
}
