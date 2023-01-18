package com.example.moviebooking.service;

import com.example.moviebooking.entity.*;
import com.example.moviebooking.repository.BookingRepository;
import com.example.moviebooking.repository.SeatPriceRepository;
import com.example.moviebooking.util.DiscountStrategy;
import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.util.DiscountStrategy_Afternoon;
import com.example.moviebooking.util.DiscountStrategy_ThirdTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
        MovieShow movieShow = showService.getShow(bookingDetails.getShowId());
        DiscountStrategy discountStrategy = null;

        List<Seat> seats = bookingDetails.getSeatIds().stream()
                .map(Seat::new)
                .collect(Collectors.toList());

        if(!discountStrategy.isValid(seats)) {
            return null;
        }

        if(movieShow.getStratergyType() == StratergyType.AFTERNOON_30)
            discountStrategy = new DiscountStrategy_Afternoon();
        else if (movieShow.getStratergyType() == StratergyType.THIRD_TICKET_50) {
            discountStrategy = new DiscountStrategy_ThirdTicket();
        }

        List<SeatPrice> seatPrices = getSeatPriceByShowId(movieShow.getId());
        Map<SeatType, Integer> seatPriceMap = seatPrices.stream().collect(Collectors.toMap(obj->obj.getSeatType(), obj->obj.getPrice()));

        Booking booking = new Booking();
        booking.setSeats((Set<Seat>) seats);
        booking.setAmount(discountStrategy.calculate(movieShow, bookingDetails, seatPriceMap));
        bookingRepository.save(booking);
        return booking;
    }

    public List<SeatPrice> getSeatPriceByShowId(int id) {
        return (List<SeatPrice>) seatPriceRepository.findByMovieShowId(id);
    }
}
