package com.boris.skillbox.diploma.skillbox_diploma.repository;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostVotesRepository extends JpaRepository<Like, Long> {

    List<Like> findAllByPostId(long postId);
}
