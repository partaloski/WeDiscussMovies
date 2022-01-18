package com.wediscussmovies.project.service.impl;

import com.wediscussmovies.project.model.*;
import com.wediscussmovies.project.repository.GenreRepository;
import com.wediscussmovies.project.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> findAllByType(String genre) {
        return genreRepository.findAllByGenreType(genre);
    }

    @Override
    public Genre save(String genreName) {
       Genre genre = new Genre(genreName);
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
