package com.wediscussmovies.project.repository;

import com.wediscussmovies.project.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    public List<Genre> findAllByGenreType(String genre);
}
