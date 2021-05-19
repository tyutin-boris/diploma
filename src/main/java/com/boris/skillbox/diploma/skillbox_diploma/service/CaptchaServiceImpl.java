package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.CaptchaCodes;
import com.boris.skillbox.diploma.skillbox_diploma.repository.CaptchaRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.CaptchaService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    private CaptchaRepository captchaRepository;

    public CaptchaServiceImpl(CaptchaRepository captchaRepository) {
        this.captchaRepository = captchaRepository;
    }

    @Override
    public void save(CaptchaCodes captchaCodes) {
        captchaRepository.save(captchaCodes);
    }

    @Override
    public void deleteAllOldCaptcha(long limit) {
        captchaRepository.deleteAll(captchaRepository
                .findAll()
                .stream()
                .filter(captchaCodes -> captchaCodes.isOld(limit))
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equalsCaptcha(String secret, String captchaCode) {
        CaptchaCodes captchaCodes = captchaRepository.findBySecret(secret);
        return captchaCodes.getCode().equals(captchaCode);
    }
}
