package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.post.Comment;
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
public class CommentResponse {
    private long id;
    private long timestamp;
    private String text;
    private UserResponse user;


    public static List<CommentResponse> getCommentResponseList(List<Comment> comments) {
        return comments.stream().map(CommentResponse::getCommentResponse).collect(Collectors.toList());
    }

    public static CommentResponse getCommentResponse(Comment comment) {
        User user = comment.getUser();
        return new CommentResponse(
                comment.getId(),
                comment.getTime().atZone(ZoneId.systemDefault()).toEpochSecond(),
                comment.getText(),
                new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getPhoto())
        );
    }
}
