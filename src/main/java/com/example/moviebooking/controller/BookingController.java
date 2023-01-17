package com.example.moviebooking.controller;

import com.example.moviebooking.dto.BookingDetails;
import com.example.moviebooking.entity.Booking;
import com.example.moviebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking/book")
    public Booking book(@RequestBody BookingDetails bookingDetails) {
        return bookingService.book(bookingDetails);
    }

}
