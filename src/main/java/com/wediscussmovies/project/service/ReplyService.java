package com.wediscussmovies.project.service;

import com.wediscussmovies.project.model.Reply;

import java.util.Optional;

public interface ReplyService {
    public Reply save(Reply r);
    public void delete(Reply r);
    Optional<Reply> findById(Long id);

}
