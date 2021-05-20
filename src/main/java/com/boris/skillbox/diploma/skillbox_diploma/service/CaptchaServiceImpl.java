package com.boris.skillbox.diploma.skillbox_diploma.service;

import cn.apiclub.captcha.Captcha;
import com.boris.skillbox.diploma.skillbox_diploma.model.captcha.CaptchaGenerator;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.CaptchaCode;
import com.boris.skillbox.diploma.skillbox_diploma.repository.CaptchaRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.CaptchaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    private CaptchaRepository captchaRepository;
    private CaptchaGenerator captchaGenerator;

    public CaptchaServiceImpl(CaptchaRepository captchaRepository, CaptchaGenerator captchaGenerator) {
        this.captchaRepository = captchaRepository;
        this.captchaGenerator = captchaGenerator;
    }

    @Override
    public void save(CaptchaCode captchaCodes) {
        captchaRepository.save(captchaCodes);
    }


    @Override
    public Captcha getCaptcha() {
        Captcha captcha = captchaGenerator.createCaptcha(135, 50);
        CaptchaCode captchaCode = getCaptchaCode(captcha);
        save(captchaCode);
        deleteAllOldCaptchas(3600);
        return captcha;
    }

    @Override
    public boolean isCaptchaValid(String secret, String code) {
        CaptchaCode captchaCode = captchaRepository.findBySecret(secret);
        return captchaCode.getCode().equals(code);
    }

    private CaptchaCode getCaptchaCode(Captcha captcha) {
        return new CaptchaCode(
                LocalDateTime.now(),
                captcha.getAnswer(),
                String.valueOf(captcha.getAnswer().hashCode()));
    }

    private void deleteAllOldCaptchas(long limit) {
        captchaRepository.deleteAll(captchaRepository
                .findAll()
                .stream()
                .filter(captchaCodes -> captchaCodes.isOld(limit))
                .collect(Collectors.toList()));
    }
}
