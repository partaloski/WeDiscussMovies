package com.wediscussmovies.project.service.impl;

import com.wediscussmovies.project.model.*;
import com.wediscussmovies.project.repository.MovieRepository;
import com.wediscussmovies.project.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(1);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieRepository.findAllByTitleLike("%"+title+"%");
    }
}


