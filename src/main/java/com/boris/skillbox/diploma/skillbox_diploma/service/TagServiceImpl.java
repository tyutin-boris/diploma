package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag.Tag;
import com.boris.skillbox.diploma.skillbox_diploma.repository.TagRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> findAllByName(String name) {
        return tagRepository.findAllByName(name);
    }

    @Override
    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }
}
