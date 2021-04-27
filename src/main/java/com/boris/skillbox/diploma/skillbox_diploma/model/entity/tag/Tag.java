package com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "tag_to_post",
    joinColumns = @JoinColumn(name="tag_id"),
    inverseJoinColumns = @JoinColumn(name="post_id"))
    private List<Post> post;
}
