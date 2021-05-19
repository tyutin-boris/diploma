package com.boris.skillbox.diploma.skillbox_diploma.controller;

import cn.apiclub.captcha.Captcha;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.CaptchaResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.ErrorResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.FormResponse;
import com.boris.skillbox.diploma.skillbox_diploma.controller.request.RegisterRequest;
import com.boris.skillbox.diploma.skillbox_diploma.controller.response.RegisterResponse;
import com.boris.skillbox.diploma.skillbox_diploma.model.captcha.CaptchaGenerator;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.CaptchaCodes;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.CaptchaService;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private CaptchaGenerator captchaGenerator;
    private CaptchaService captchaService;
    private UserService userService;

    public ApiAuthController(CaptchaGenerator captchaGenerator, CaptchaService captchaService, UserService userService) {
        this.captchaGenerator = captchaGenerator;
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
        Captcha captcha = captchaGenerator.createCaptcha(135, 50);
        CaptchaCodes captchaCodes = new CaptchaCodes(
                LocalDateTime.now(),
                captcha.getAnswer(),
                String.valueOf(captcha.getAnswer().hashCode()));
        captchaService.save(captchaCodes);
        captchaService.deleteAllOldCaptcha(3600);
        return CaptchaResponse.getCaptchaResponse(captcha);
    }

    @PostMapping("/register")
    public RegisterResponse setUser(@RequestBody RegisterRequest registerRequest) {
        boolean equalsCaptcha = captchaService.equalsCaptcha(
                registerRequest.getCaptcha_secret(),
                registerRequest.getCaptcha());
        if (equalsCaptcha) {
            User user = new User(
                    registerRequest.getName(),
                    registerRequest.getE_mail(),
                    registerRequest.getPassword(),
                    LocalDateTime.now(),
                    false
            );
            userService.save(user);
            return new RegisterResponse(true);
        } else {
            return new RegisterResponse(
                    false,
                    new ErrorResponse(
                            "Этот e-mail уже зарегистрирован",
                            "Имя указано неверно",
                            "Пароль короче 6-ти символов",
                            "Код с картинки введён неверно"
                    ));
        }
    }
}
