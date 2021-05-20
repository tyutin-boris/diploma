package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.controller.request.RegisterRequest;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;
import com.boris.skillbox.diploma.skillbox_diploma.repository.UserRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.CaptchaService;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private CaptchaService captchaService;

    public UserServiceImpl(UserRepository userRepository, CaptchaService captchaService) {
        this.userRepository = userRepository;
        this.captchaService = captchaService;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean userIsSaved(RegisterRequest reg) {
        if (!isCaptchaValid(reg)) return false;
        if (userExistsValidation(reg)) return false;
        save(new User(reg.getName(), reg.getEmail(), reg.getPassword(), LocalDateTime.now(), false));
        return true;
    }

    private boolean userExistsValidation(RegisterRequest reg) {
        return !userRepository.findUser(reg.getName(), reg.getEmail()).isEmpty();
    }

    private boolean isCaptchaValid(RegisterRequest reg) {
        return captchaService.isCaptchaValid(reg.getCaptchaSecret(), reg.getCaptcha() );
    }
}
