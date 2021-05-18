package com.boris.skillbox.diploma.skillbox_diploma.controller;

import com.boris.skillbox.diploma.skillbox_diploma.controller.response.FormResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    @GetMapping("/check")
    public FormResponse check() {
        return new FormResponse(
                true,
                new UserResponse(1L,
                        "Ivan",
                        "",
                        "IvanIvanov@mail.com",
                        true,
                        2,
                        true));

    }
}
