package com.boris.skillbox.diploma.skillbox_diploma.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @JsonProperty(value = "e_mail")
    private String email;

    private String password;

    private String name;

    private String captcha;

    @JsonProperty(value = "captcha_secret")
    private String captchaSecret;

}
