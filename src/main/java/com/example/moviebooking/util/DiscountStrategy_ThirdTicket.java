package com.example.moviebooking.util;

import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.entity.Seat;
import com.example.moviebooking.entity.SeatPrice;
import com.example.moviebooking.entity.SeatType;
import com.example.moviebooking.entity.Show;
import com.example.moviebooking.repository.SeatPriceRepository;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiscountStrategy_ThirdTicket extends DiscountStrategy{

    @Override
    public double calculate(Show show, BookingDetails bookingDetails, Map<SeatType, Integer> seatPriceMap) {
        List<Seat> seats = bookingDetails.getSeatIds().stream()
                .map(Seat::new)
                .collect(Collectors.toList());

        double amount =0;
        boolean eligibleForDisc = false;
        if(seats.size() > 2) {
            eligibleForDisc = true;
        }
        for(int i=0; i<seats.size(); i++) {
            Integer seatPrice = seatPriceMap.get(seats.get(i).getSeatType());
            if(i > 2) {
                seatPrice = (seatPrice * 50)/100;
            }
            amount += seatPrice.intValue();
        }
        return amount;
    }
}
