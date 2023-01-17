package com.example.moviebooking.util;

import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.entity.Show;
import com.example.moviebooking.repository.SeatPriceRepository;

public class DiscountStrategy_ThirdTicket extends DiscountStrategy{

    @Override
    public double calculate(Show show, BookingDetails bookingDetails, SeatPriceRepository seatPriceRepository) {
        return 0;
    }
}
