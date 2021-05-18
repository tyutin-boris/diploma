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
public class FormResponse {

    private boolean result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserResponse user;
}
