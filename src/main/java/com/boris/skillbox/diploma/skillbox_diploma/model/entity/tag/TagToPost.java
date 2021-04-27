package com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tag_to_post")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TagToPost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "post_id", nullable = false)
    private long postId;

    @Column(name = "tag_id", nullable = false)
    private long tagId;
}