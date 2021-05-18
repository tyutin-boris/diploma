package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    public List<Tag> findAllByName(String name);

    public Tag findByName(String name);
}
