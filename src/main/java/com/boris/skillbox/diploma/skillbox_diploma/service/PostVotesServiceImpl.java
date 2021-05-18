package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Like;
import com.boris.skillbox.diploma.skillbox_diploma.repository.PostVotesRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.PostVotesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostVotesServiceImpl implements PostVotesService {

    private PostVotesRepository postVotesRepository;

    public PostVotesServiceImpl(PostVotesRepository postVotesRepository) {
        this.postVotesRepository = postVotesRepository;
    }

    @Override
    public List<Like> findAllByPostId(long postId) {
        return postVotesRepository.findAllByPostId(postId);
    }
}
