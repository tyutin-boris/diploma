package com.boris.skillbox.diploma.skillbox_diploma.controller;

import com.boris.skillbox.diploma.skillbox_diploma.controller.response.BlogResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.CalendarResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.TagFormResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.TagResponse;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.GlobalSettings;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag.Tag;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.GlobalSettingsService;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.PostService;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;


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
        return ResponseEntity.ok(globalSettingsService.getAllGlobalSettings()
                .stream()
                .collect(Collectors.toMap(GlobalSettings::getCode, GlobalSettings::isValue)));
    }

    @PutMapping("/settings")
    public void updateSettings(@RequestBody Map<String, Boolean> settings) {
        globalSettingsService.saveAll(settings);
    }

    @GetMapping("/tag")
    public TagFormResponse getAllTag() {

        List<Tag> tags = tagService.findAll();
        List<Post> posts = postService.findAll();
        List<TagResponse> tagResponses = new ArrayList<>();

        Map<String, Double> weightTag = getWeightTag(posts.size(), tags);
        for (Map.Entry<String, Double> entry : weightTag.entrySet()) {
            tagResponses.add(new TagResponse(entry.getKey(), entry.getValue()));
        }
        return new TagFormResponse(tagResponses);
    }

    @GetMapping("/calendar")
    public CalendarResponse getNumbersOfPostsPerYear(@RequestParam String year) {
        String data = year.isEmpty() ? LocalDate.now().format(DateTimeFormatter.ISO_DATE).substring(0, 4) : year;
        return postService.getNumbersOfPostPerYear(data);
    }

    private double getDWeightTag(double postCount, double tagCount) {
        return tagCount / postCount;

    }

    private Map<String, Double> getWeightTag(double postCount, List<Tag> tags) {
        Map<String, Double> weightTags = new HashMap<>();

        double tagWithMaxWeight = tags.stream().mapToDouble(tag -> tag.getPost().size()).max().getAsDouble();
        double k = 1 / getDWeightTag(postCount, tagWithMaxWeight);

        for (Tag tag : tags) {
            int tagCount = tag.getPost().size();
            double tagWeight = getDWeightTag(postCount, tagCount);
            weightTags.put(tag.getName(), tagWeight * k);
        }
        return weightTags;
    }
}
