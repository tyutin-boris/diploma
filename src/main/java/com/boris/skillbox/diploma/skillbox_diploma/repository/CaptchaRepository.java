package com.boris.skillbox.diploma.skillbox_diploma.repository;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.CaptchaCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptchaRepository extends JpaRepository<CaptchaCode, Long> {

    CaptchaCode findBySecret(String captchaSecret);
}
