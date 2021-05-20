package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostWithCommentsAndTagsResponse {
    private long id;
    private long timestamp;
    private boolean active;
    private UserResponse user;
    private String title;
    private String text;
    private long likeCount;
    private long dislikeCount;
    private long viewCount;
    private List<CommentResponse> commentResponse;
    private List<String> tagResponse;

    public PostWithCommentsAndTagsResponse getPostWithCommentsAndTagsResponse(Post post) {
        return new PostWithCommentsAndTagsResponse(
                post.getId(),
                post.getTime().atZone(ZoneId.systemDefault()).toEpochSecond(),
                post.isActive(),
                new UserResponse(
                        post.getUser().getId(),
                        post.getUser().getName()
                ),
                post.getTitle(),
                post.getText(),
                post.getLikes().size(),
                post.getDisLikes().size(),
                post.getViewCount(),
                CommentResponse.getCommentResponseList(post.getComments()),
                post.getTags().stream().map(Tag::getName).collect(Collectors.toList())
        );
    }
}
