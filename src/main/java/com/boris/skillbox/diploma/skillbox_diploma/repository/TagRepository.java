package com.boris.skillbox.diploma.skillbox_diploma.repository;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
