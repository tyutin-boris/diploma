package com.boris.skillbox.diploma.skillbox_diploma.controller;


import com.boris.skillbox.diploma.skillbox_diploma.controller.response.BlogResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.CalendarResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.TagFormResponse;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.GlobalSettingsService;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.PostService;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    private GlobalSettingsService globalSettingsService;
    private PostService postService;
    private TagService tagService;

    public ApiGeneralController(GlobalSettingsService globalSettingsService, PostService postService, TagService tagService) {
        this.globalSettingsService = globalSettingsService;
        this.postService = postService;
        this.tagService = tagService;
    }

    @GetMapping("/init")
    public BlogResponse init() {
        return new BlogResponse(
                "DevPub",
                "Blog developers",
                "+79036664455",
                "mail@mail.ru",
                "Ivan Ivanov",
                "2021"
        );
    }

    @GetMapping("/settings")
    public ResponseEntity settings() {
        return ResponseEntity.ok(globalSettingsService.getAllGlobalSettings());
    }

    @PutMapping("/settings")
    public void updateSettings(@RequestBody Map<String, Boolean> settings) {
        globalSettingsService.saveAll(settings);
    }

    @GetMapping("/tag")
    public TagFormResponse getAllTags() {
        return new TagFormResponse(tagService.getAllTags());
    }

    @GetMapping("/calendar")
    public CalendarResponse getNumbersOfPostsPerYear(@RequestParam String year) {
        return postService.getNumbersOfPostPerYear(year);
    }
}
