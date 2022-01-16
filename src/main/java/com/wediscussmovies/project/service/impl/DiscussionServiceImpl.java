package com.wediscussmovies.project.service.impl;

import com.wediscussmovies.project.model.Discussion;
import com.wediscussmovies.project.repository.DiscussionRepository;
import com.wediscussmovies.project.service.DiscussionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionServiceImpl implements DiscussionService {
    private final DiscussionRepository discussionRepository;

    public DiscussionServiceImpl(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    @Override
    public List<Discussion> listAll() {
        return discussionRepository.findAll();
    }

    @Override
    public void save(Discussion discussion) {
        discussionRepository.save(discussion);
    }

    @Override
    public Optional<Discussion> findById(Integer id) {
        return discussionRepository.findById(id);
    }

    @Override
    public List<Discussion> listAllByTitle(String title) {
        return discussionRepository.findAllByTitleLike("%"+title+"%");
    }
}
