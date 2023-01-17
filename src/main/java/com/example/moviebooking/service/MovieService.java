package com.example.moviebooking.service;

import com.example.moviebooking.entity.Address;
import com.example.moviebooking.entity.Movie;
import com.example.moviebooking.entity.User;
import com.example.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovie(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie updateMovie(Movie movie) {
        Movie tempMovie = movieRepository.findById(movie.getId()).orElse(null);
        if(tempMovie == null)
            return null;
        tempMovie.setMovieName(movie.getMovieName());
        return movieRepository.save(tempMovie);
    }

    public String removeMovie(int id) {
        movieRepository.deleteById(id);
        return "Movie Deleted " + id;
    }
}
