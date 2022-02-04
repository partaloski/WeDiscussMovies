package com.wediscussmovies.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.wediscussmovies.project.model.*;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    public List<Movie> findAllByTitleLike(String Title);
}
