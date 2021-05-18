package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Post;
import lombok.*;
import org.springframework.data.domain.Page;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private long id;
    private long timestamp;
    private UserResponse user;
    private String title;
    private String announce;
    private long likeCount;
    private long dislikeCount;
    private long commentCount;
    private long viewCount;

    public static PostResponse getPostResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTime().atZone(ZoneId.systemDefault()).toEpochSecond(),
                new UserResponse(post.getUser().getId(), ""),
                post.getTitle(),
                post.getText().length() > 150 ?
                        post.getText().substring(0, 150) + "..." :
                        post.getText(),
                post.getLikes().size(),
                post.getDisLikes().size(),
                post.getComments().size(),
                post.getViewCount()
        );
    }

    public static List<PostResponse> getListPostResponse(Page<Post> posts) {
        return posts.stream().map(PostResponse::getPostResponse).collect(Collectors.toList());
    }
}
