package com.boris.skillbox.diploma.skillbox_diploma.repository;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto.NumbersOfPostDTO;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto.YearDTO;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.isActive = true AND p.moderationStatus = 1 ")
    Page<Post> findAll(Pageable pageable);

    @Query("SELECT p FROM Post p LEFT JOIN p.comments c ON p.id = c.post.id " +
            "WHERE p.isActive = true AND p.moderationStatus = 1 " +
            " GROUP BY p.id ORDER BY COUNT(c.post.id) DESC")
    Page<Post> getPostsSortByComment(Pageable pageable);

    @Query("SELECT p FROM Post p LEFT JOIN p.likes l ON p.id = l.post.id" +
            " WHERE p.isActive = true AND p.moderationStatus = 1 " +
            " GROUP BY p.id ORDER BY COUNT(l.post.id) DESC")
    Page<Post> getPostsSortByLike(Pageable pageable);

    @Query(value = "SELECT new com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto" +
            ".YearDTO(TO_CHAR(p.time, 'yyyy')) FROM Post p WHERE p.isActive = true AND p.moderationStatus = 1 GROUP BY TO_CHAR(p.time, 'yyyy')")
    List<YearDTO> getAllYears();

    @Query(value = "SELECT new com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto" +
            ".NumbersOfPostDTO(TO_CHAR(p.time, 'yyyy-mm-dd'), count(p.id)) FROM Post p " +
            "WHERE TO_CHAR(p.time, 'yyyy') = :year AND p.isActive = true AND p.moderationStatus = 1 GROUP BY TO_CHAR(p.time, 'yyyy-mm-dd')")
    List<NumbersOfPostDTO> getNumbersOfPostPerYear(@Param("year") String year);

    @Query("SELECT p FROM Post p WHERE TO_CHAR(p.time, 'yyyy-mm-dd') = :date " +
            "AND p.isActive = true AND p.moderationStatus = 1 ORDER BY p.time DESC")
    Page<Post> findAllByDate(@Param("date") String date, Pageable pageable);

    @Query("SELECT p FROM Post p " +
            "LEFT JOIN p.tags t WHERE t.name = :tag AND p.isActive = true " +
            "AND p.moderationStatus = 1 ORDER BY p.time DESC")
    Page<Post> findAllByTag(@Param("tag") String tag, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.id = :id AND p.isActive = true AND p.moderationStatus = 1")
    Post findById(@Param("id") long id);

    @Query("SELECT p FROM Post p WHERE p.isActive = true AND p.moderationStatus = 1 AND (p.title LIKE %:query% OR p.text LIKE %:query%)")
    Page<Post> findAllByTitleOrText(@Param("query") String query, Pageable pageable);
}
