package com.boris.skillbox.diploma.skillbox_diploma.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "captcha_codes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaptchaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private String code;

    @Column(name = "secret_code", nullable = false)
    private String secret;

    public CaptchaCode(LocalDateTime time, String code, String secret) {
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
