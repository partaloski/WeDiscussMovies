package com.wediscussmovies.project.service;

import com.wediscussmovies.project.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<Movie> listAll();
    public List<Movie> searchByTitle(String title);
    public Optional<Movie> findById(Long id);
    public Movie save(Movie movie);
    public void deleteById(Long id);
}
