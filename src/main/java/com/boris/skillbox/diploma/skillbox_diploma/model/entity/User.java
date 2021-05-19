package com.boris.skillbox.diploma.skillbox_diploma.model.entity;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Comment;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "is_moderator", nullable = false)
    private boolean isModerator;

    @Column(name = "reg_time", nullable = false)
    private LocalDateTime regTime;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private String code;

    private String photo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments;

    public User(String name, String email, String password, LocalDateTime regTime, boolean isModerator) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.regTime = regTime;
        this.isModerator = isModerator;
    }
}