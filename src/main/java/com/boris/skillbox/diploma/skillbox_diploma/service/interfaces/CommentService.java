package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();
}
