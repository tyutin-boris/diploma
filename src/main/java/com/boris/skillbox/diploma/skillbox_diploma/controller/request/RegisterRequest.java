package com.boris.skillbox.diploma.skillbox_diploma.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String e_mail;
    private String password;
    private String name;
    private String captcha;
    private String captcha_secret;

}
