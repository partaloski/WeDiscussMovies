package com.wediscussmovies.project.service;

import com.wediscussmovies.project.model.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> listAll();
    public List<Movie> searchByTitle(String title);
}
