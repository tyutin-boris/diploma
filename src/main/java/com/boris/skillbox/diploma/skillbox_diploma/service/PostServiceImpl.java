package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.controller.response.CalendarResponse;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto.NumbersOfPostDTO;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto.YearDTO;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import com.boris.skillbox.diploma.skillbox_diploma.repository.PostRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> findAllPostsSortByComment(Pageable pageable) {
        return postRepository.getPostsSortByComment(pageable);
    }

    @Override
    public Page<Post> findAllPostsSortByLike(Pageable pageable) {
        return postRepository.getPostsSortByLike(pageable);
    }

    @Override
    public CalendarResponse getNumbersOfPostPerYear(String year) {
        CalendarResponse calendarResponse = new CalendarResponse();
        calendarResponse.setYears(postRepository.getAllYears()
                .stream()
                .map(YearDTO::getYear)
                .collect(Collectors.toCollection(TreeSet::new)));

        calendarResponse.setPosts(postRepository.getNumbersOfPostPerYear(year)
                .stream()
                .collect(Collectors.toMap(NumbersOfPostDTO::getYear,
                        NumbersOfPostDTO::getNumbersOfPostPerYear)));
        return calendarResponse;
    }

    @Override
    public Page<Post> findAllByDate(String date, Pageable pageable) {
        return postRepository.findAllByDate(date, pageable);
    }
}
