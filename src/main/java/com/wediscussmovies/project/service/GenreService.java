package com.wediscussmovies.project.service;

import com.wediscussmovies.project.model.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GenreService {
    public List<Genre> findAll();
    public Optional<Genre> findById(Integer id);
    public List<Genre> findAllByType(String genre);
    public Genre save(String genreName);
}
