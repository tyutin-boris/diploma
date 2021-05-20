package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.controller.response.TagResponse;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag.Tag;
import com.boris.skillbox.diploma.skillbox_diploma.repository.TagRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.PostService;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.TagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;
    private PostService postService;

    public TagServiceImpl(TagRepository tagRepository, PostService postService) {
        this.tagRepository = tagRepository;
        this.postService = postService;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<TagResponse> getAllTags() {
        List<Tag> tags = findAll();
        long countPosts = postService.count();
        List<TagResponse> tagResponses = new ArrayList<>();

        Map<String, Double> weightTag = getWeightTag(countPosts, tags);
        for (Map.Entry<String, Double> entry : weightTag.entrySet()) {
            tagResponses.add(new TagResponse(entry.getKey(), entry.getValue()));
        }
        return tagResponses;
    }


    private double getDWeightTag(double postCount, double tagCount) {
        return tagCount / postCount;

    }

    private Map<String, Double> getWeightTag(double postCount, List<Tag> tags) {
        Map<String, Double> weightTags = new HashMap<>();

        double tagWithMaxWeight = tags.stream().mapToDouble(tag -> tag.getPosts().size()).max().getAsDouble();
        double k = 1 / getDWeightTag(postCount, tagWithMaxWeight);

        for (Tag tag : tags) {
            int tagCount = tag.getPosts().size();
            double tagWeight = getDWeightTag(postCount, tagCount);
            weightTags.put(tag.getName(), tagWeight * k);
        }
        return weightTags;
    }
}
