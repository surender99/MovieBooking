package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Movie;
import com.example.moviebooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/movie/addMovie")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/movie/get/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovie(id);
    }

    @PutMapping("/movie/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/movie/removeMovie/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteMovie(@RequestBody int id) {
        return movieService.removeMovie(id);
    }

}
