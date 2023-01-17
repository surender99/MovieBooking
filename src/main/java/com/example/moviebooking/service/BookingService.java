package com.example.moviebooking.service;

import com.example.moviebooking.config.UserDetailsImpl;
import com.example.moviebooking.entity.*;
import com.example.moviebooking.repository.BookingRepository;
import com.example.moviebooking.repository.SeatPriceRepository;
import com.example.moviebooking.repository.ShowRepository;
import com.example.moviebooking.util.DiscountStrategy;
import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.util.DiscountStrategy_Afternoon;
import com.example.moviebooking.util.DiscountStrategy_ThirdTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    ShowService showService;
    DiscountStrategy discountStrategy;
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    SeatPriceRepository seatPriceRepository;

    public Booking book(BookingDetails bookingDetails) {
        Show show = showService.getShow(bookingDetails.getShowId());
        DiscountStrategy discountStrategy = null;

        List<Seat> seats = bookingDetails.getSeatIds().stream()
                .map(Seat::new)
                .collect(Collectors.toList());

        if(!discountStrategy.isValid(seats)) {
            return null;
        }

        if(show.getStratergyType() == StratergyType.AFTERNOON_30)
            discountStrategy = new DiscountStrategy_Afternoon();
        else if (show.getStratergyType() == StratergyType.THIRD_TICKET_50) {
            discountStrategy = new DiscountStrategy_ThirdTicket();
        }

        Booking booking = new Booking();
        booking.setSeats((Set<Seat>) seats);
        booking.setShowBooking(new ShowBooking());
        booking.setAmount(discountStrategy.calculate(show, bookingDetails, seatPriceRepository));
        bookingRepository.save(booking);
        return booking;
    }

    public int getSeatPriceByShowId(int id) {
        return seatPriceRepository.get(getSeatPriceByShowId(id));
    }
}
