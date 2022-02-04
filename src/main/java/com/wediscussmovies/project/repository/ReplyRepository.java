package com.wediscussmovies.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wediscussmovies.project.model.*;


@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
