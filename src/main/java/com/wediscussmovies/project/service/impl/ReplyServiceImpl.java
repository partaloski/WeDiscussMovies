package com.wediscussmovies.project.service.impl;

import com.wediscussmovies.project.repository.ReplyRepository;
import com.wediscussmovies.project.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public Optional<Reply> findById(Integer id) {
        return replyRepository.findById(id);
    }

    @Override
    public void delete(Reply r) {
        replyRepository.delete(r);
    }

    @Override
    public Reply save(Reply r) {
        return replyRepository.save(r);
    }
}
