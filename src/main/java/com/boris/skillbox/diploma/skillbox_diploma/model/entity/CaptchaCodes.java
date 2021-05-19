package com.boris.skillbox.diploma.skillbox_diploma.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "captcha_codes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CaptchaCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private String code;

    @Column(name = "secret_code", nullable = false)
    private String secret;

    public CaptchaCodes(LocalDateTime time, String code, String secret) {
        this.time = time;
        this.code = code;
        this.secret = secret;
    }

    public boolean isOld(long limit) {
        long captchaMilliseconds = this.time.atZone(ZoneId.systemDefault()).toEpochSecond();
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
        return (now - captchaMilliseconds) > limit;
    }
}
