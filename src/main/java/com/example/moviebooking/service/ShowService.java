package com.example.moviebooking.service;

import com.example.moviebooking.entity.MovieShow;
import com.example.moviebooking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    public MovieShow addShow(MovieShow movieShow) {
        return showRepository.save(movieShow);
    }
    public MovieShow getShow(int id) {
        return showRepository.getById(id);
    }
    public MovieShow updateShow(MovieShow movieShow) {
        MovieShow movieShowTemp = showRepository.findById(movieShow.getId()).orElse(null);
        if(movieShowTemp == null)
            return null;
        return showRepository.save(movieShowTemp);
    }
    public String removeShow(int id) {
        showRepository.deleteById(id);
        return "Show Deleted " + id;
    }
}
