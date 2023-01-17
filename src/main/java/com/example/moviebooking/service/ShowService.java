package com.example.moviebooking.service;

import com.example.moviebooking.entity.Show;
import com.example.moviebooking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    public Show addShow(Show show) {
        return showRepository.save(show);
    }
    public Show getShow(int id) {
        return showRepository.getById(id);
    }
    public Show updateShow(Show show) {
        Show showTemp = showRepository.findById(show.getId()).orElse(null);
        if(showTemp == null)
            return null;
        return showRepository.save(showTemp);
    }
    public String removeShow(int id) {
        showRepository.deleteById(id);
        return "Show Deleted " + id;
    }
}
