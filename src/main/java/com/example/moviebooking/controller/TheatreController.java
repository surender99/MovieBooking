package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Theatre;
import com.example.moviebooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Theatre addTheatre(@RequestBody Theatre theatre) {
        return theatreService.saveTheatre(theatre);
    }

    @GetMapping("get/{id}")
    public Theatre getTheatre(@PathVariable int id) {
        return theatreService.getTheatre(id);
    }

    @PutMapping("/update")
    public Theatre updateMovie(@RequestBody Theatre theatre) {
        return theatreService.updateTheatre(theatre);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTheatre(@RequestBody int id) {
        return theatreService.removeTheatre(id);
    }
}
