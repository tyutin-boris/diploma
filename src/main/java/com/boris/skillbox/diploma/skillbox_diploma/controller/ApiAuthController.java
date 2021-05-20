package com.boris.skillbox.diploma.skillbox_diploma.controller;


import com.boris.skillbox.diploma.skillbox_diploma.controller.request.RegisterRequest;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.CaptchaResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.ErrorResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.FormResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.RegisterResponse;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.CaptchaService;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {


    private CaptchaService captchaService;
    private UserService userService;

    public ApiAuthController(CaptchaService captchaService, UserService userService) {
        this.captchaService = captchaService;
        this.userService = userService;
    }

    @GetMapping("/check")
    public FormResponse check() {
//        return new FormResponse(
//                true,
//                new UserResponse(1L,
//                        "Ivan",
//                        "",
//                        "IvanIvanov@mail.com",
//                        true,
//                        2,
//                        true));
        return new FormResponse();

    }

    @GetMapping("/captcha")
    public CaptchaResponse getCaptcha() {
        return CaptchaResponse.getCaptchaResponse(captchaService.getCaptcha());
    }

    @PostMapping("/register")
    public RegisterResponse setUser(@RequestBody RegisterRequest registerRequest) {
        boolean isSaved = userService.userIsSaved(registerRequest);
        if (isSaved) {
            return new RegisterResponse(isSaved);
        } else {
            return new RegisterResponse(
                    isSaved,
                    new ErrorResponse(
                            "Этот e-mail уже зарегистрирован",
                            "Пользователь с таким именем уже зарегистрирован",
                            "Пароль короче 6-ти символов",
                            "Код с картинки введён неверно"
                    ));
        }
    }
}
