package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.controller.response.TagResponse;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    List<TagResponse> getAllTags();
}
