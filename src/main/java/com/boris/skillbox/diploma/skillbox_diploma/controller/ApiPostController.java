package com.boris.skillbox.diploma.skillbox_diploma.controller;

import com.boris.skillbox.diploma.skillbox_diploma.controller.response.PostFormResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.PostResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.PostWithCommentsAndTagsResponse;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class ApiPostController {

    private PostService postService;

    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public PostFormResponse getAllPosts(
            @RequestParam int offset,
            @RequestParam int limit,
            @RequestParam String mode) {

        int page = offset / limit;
        Page<Post> posts = Page.empty();

        switch (mode) {
            case "recent":
                posts = postService.findAll(PageRequest.of(page, limit, Sort.by("time").descending()));
                break;
            case "early":
                posts = postService.findAll(PageRequest.of(page, limit, Sort.by("time").ascending()));
                break;
            case "popular":
                posts = postService.findAllPostsSortByComment(PageRequest.of(page, limit));
                break;
            case "best":
                posts = postService.findAllPostsSortByLike(PageRequest.of(page, limit));
                break;
        }
        return new PostFormResponse(posts.getTotalElements(), PostResponse.getListPostResponse(posts));
    }

    @GetMapping("/post/byDate")
    public PostFormResponse getAllPostsByDate(@RequestParam int offset,
                                              @RequestParam int limit,
                                              @RequestParam String date) {
        int page = getPage(offset, limit);

        Page<Post> posts = postService.findAllByDate(date, PageRequest.of(page, limit));
        return new PostFormResponse(posts.getTotalElements(), PostResponse.getListPostResponse(posts));
    }

    @GetMapping("/post/byTag")
    public PostFormResponse getAllPostsByTag(@RequestParam int offset,
                                             @RequestParam int limit,
                                             @RequestParam String tag) {
        int page = getPage(offset, limit);
        Page<Post> posts = postService.findAllByTag(tag, PageRequest.of(page, limit));
        return new PostFormResponse(posts.getTotalElements(), PostResponse.getListPostResponse(posts));
    }

    @GetMapping("/post/{id}")
    public PostWithCommentsAndTagsResponse getPostById(@PathVariable("id") long id) {
        Post post = postService.findById(id);
        return new PostWithCommentsAndTagsResponse().getPostWithCommentsAndTagsResponse(post);
    }

    @GetMapping("post/search")
    public PostFormResponse findPost(@RequestParam int offset,
                                     @RequestParam int limit,
                                     @RequestParam String query) {
        int page = getPage(offset, limit);
        Page<Post> posts = postService.findAllByTitleOrText(query, PageRequest.of(page, limit, Sort.by("time").descending()));
        return new PostFormResponse(posts.getTotalElements(), PostResponse.getListPostResponse(posts));
    }

    private int getPage(int offset, int limit) {
        return offset / limit;
    }
}
