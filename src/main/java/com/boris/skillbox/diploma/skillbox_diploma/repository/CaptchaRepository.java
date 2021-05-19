package com.boris.skillbox.diploma.skillbox_diploma.repository;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.CaptchaCodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptchaRepository extends JpaRepository<CaptchaCodes, Long> {

    CaptchaCodes findBySecret(String captchaSecret);
}
