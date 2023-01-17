package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Show;
import com.example.moviebooking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/show/addMovie")
    public Show addMovie(@RequestBody Show show) {
        return showService.addShow(show);
    }

    @GetMapping("/show/get/{id}")
    public Show getMovie(@RequestBody int id) {
        return showService.getShow(id);
    }

    @PutMapping("/show/update")
    public Show updateMovie(@RequestBody Show show) {
        return showService.updateShow(show);
    }

    @DeleteMapping("/show/removeShow/{id}")
    public String removeShow(@RequestBody int id) {
        return showService.removeShow(id);
    }
}
