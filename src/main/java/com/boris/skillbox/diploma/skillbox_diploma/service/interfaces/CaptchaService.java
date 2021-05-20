package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import cn.apiclub.captcha.Captcha;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.CaptchaCode;

public interface CaptchaService {

    void save(CaptchaCode captchaCodes);

    Captcha getCaptcha();

    boolean isCaptchaValid(String captchaSecret, String captchaCode);
}
