package com.example.moviebooking.util;

import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.entity.Seat;
import com.example.moviebooking.entity.SeatPrice;
import com.example.moviebooking.entity.SeatType;
import com.example.moviebooking.entity.Show;
import com.example.moviebooking.repository.SeatPriceRepository;
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

    public abstract double calculate(Show show, BookingDetails bookingDetails, Map<SeatType, Integer> seatPriceMap);
}
