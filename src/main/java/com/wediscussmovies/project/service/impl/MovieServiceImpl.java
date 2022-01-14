package com.wediscussmovies.project.service.impl;

import com.wediscussmovies.project.model.Movie;
import com.wediscussmovies.project.repository.MovieRepository;
import com.wediscussmovies.project.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieRepository.findAllByTitleLike("%"+title+"%");
    }
}
