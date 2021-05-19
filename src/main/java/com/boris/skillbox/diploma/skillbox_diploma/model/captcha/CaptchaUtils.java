package com.boris.skillbox.diploma.skillbox_diploma.model.captcha;

import cn.apiclub.captcha.Captcha;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class CaptchaUtils {
    public static String encodeBase64(Captcha captcha) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(captcha.getImage(), "png", outputStream);
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
