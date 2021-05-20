package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String email;
    private String name;
    private String password;
    private String captcha;
}
