package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import cn.apiclub.captcha.Captcha;
import com.boris.skillbox.diploma.skillbox_diploma.model.captcha.CaptchaUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaptchaResponse {
    private String secret;
    private String image;

    public static CaptchaResponse getCaptchaResponse(Captcha captcha) {
        return new CaptchaResponse(
                String.valueOf(captcha.getAnswer().hashCode()),
                "data:image/png;base64, " + CaptchaUtils.encodeBase64(captcha)
        );
    }
}
