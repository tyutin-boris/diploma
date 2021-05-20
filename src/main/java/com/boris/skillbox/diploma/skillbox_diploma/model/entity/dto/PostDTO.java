package com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
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
