package com.boris.skillbox.diploma.skillbox_diploma.model.entity.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_votes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostVote {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "post_id", nullable = false)
    private long postId;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private boolean value;
}