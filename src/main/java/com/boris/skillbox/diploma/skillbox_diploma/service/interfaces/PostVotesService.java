package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Like;

import java.util.List;

public interface PostVotesService {

    List<Like> findAllByPostId(long postId);
}
