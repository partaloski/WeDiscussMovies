package com.wediscussmovies.project.repository;

import com.wediscussmovies.project.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    public List<Movie> findAllByTitleLike(String Title);
}
