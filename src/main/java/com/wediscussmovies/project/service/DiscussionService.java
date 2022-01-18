package com.wediscussmovies.project.service;

import com.wediscussmovies.project.model.*;

import java.util.List;
import java.util.Optional;

public interface DiscussionService {
    List<Discussion> listAll();
    List<Discussion> listAllByTitle(String title);
    Optional<Discussion> findById(Integer id);
    void save(Discussion discussion);
}
