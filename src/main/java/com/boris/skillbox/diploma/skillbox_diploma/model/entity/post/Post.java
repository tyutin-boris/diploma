package com.boris.skillbox.diploma.skillbox_diploma.model.entity.post;


import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.enums.Status;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "moderation_status", nullable = false)
    private Status moderationStatus;

    @Column(name = "moderation_id")
    private Long moderationId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2048)
    private String text;

    @Column(name = "view_count", nullable = false)
    private int viewCount;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "post")
    private List<Like> likes;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "post")
    private List<DisLike> disLikes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "tag_to_post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
}
