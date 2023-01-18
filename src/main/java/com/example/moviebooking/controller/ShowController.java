package com.example.moviebooking.controller;

import com.example.moviebooking.entity.MovieShow;
import com.example.moviebooking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/show/addMovie")
    public MovieShow addMovie(@RequestBody MovieShow movieShow) {
        return showService.addShow(movieShow);
    }

    @GetMapping("/show/get/{id}")
    public MovieShow getMovie(@RequestBody int id) {
        return showService.getShow(id);
    }

    @PutMapping("/show/update")
    public MovieShow updateMovie(@RequestBody MovieShow movieShow) {
        return showService.updateShow(movieShow);
    }

    @DeleteMapping("/show/removeShow/{id}")
    public String removeShow(@RequestBody int id) {
        return showService.removeShow(id);
    }
}
