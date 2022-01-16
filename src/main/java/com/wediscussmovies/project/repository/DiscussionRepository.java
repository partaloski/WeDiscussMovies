package com.wediscussmovies.project.repository;

import com.wediscussmovies.project.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {
    public List<Discussion> findAllByTitleLike(String title);
}
