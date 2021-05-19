package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.CaptchaCodes;

public interface CaptchaService {

    void save(CaptchaCodes captchaCodes);

    void deleteAllOldCaptcha(long limit);

    boolean equalsCaptcha(String captchaSecret, String captchaCode);
}
