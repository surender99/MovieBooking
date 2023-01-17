package com.example.moviebooking.service;

import com.example.moviebooking.entity.Theatre;
import com.example.moviebooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre saveTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre getTheatre(int id) {
        return theatreRepository.findById(id).orElse(null);
    }

    public Theatre updateTheatre(Theatre theatre) {
        Theatre theatreTemp = theatreRepository.findById(theatre.getId()).orElse(null);
        if(theatreTemp == null)
            return null;
        return theatreRepository.save(theatreTemp);
    }

    public String removeTheatre(int id) {
        theatreRepository.deleteById(id);
        return "Theatre Deleted " +id;
    }
}
