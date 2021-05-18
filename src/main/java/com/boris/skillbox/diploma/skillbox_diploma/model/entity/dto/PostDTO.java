package com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private long id;
    private boolean isActive;
    private Status moderationStatus;
    private Long moderationId;
    private User user;
    private LocalDateTime time;
    private String title;
    private String text;
    private int viewCount;
}
