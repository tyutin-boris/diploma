package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private long id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String photo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean moderation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int moderationCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean settings;

    public UserResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
