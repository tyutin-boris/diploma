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
public class RegisterResponse {

    private boolean result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorResponse errors;

    public RegisterResponse(boolean result) {
        this.result = result;
    }
}
