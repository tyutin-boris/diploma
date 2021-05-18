package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.controller.response.CalendarResponse;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllPostsSortByComment(Pageable pageable);

    Page<Post> findAllPostsSortByLike(Pageable pageable);

    CalendarResponse getNumbersOfPostPerYear(String year);

    Page<Post> findAllByDate(String date, Pageable pageable);
}
