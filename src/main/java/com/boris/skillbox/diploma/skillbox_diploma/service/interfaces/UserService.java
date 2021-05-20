package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.controller.request.RegisterRequest;
import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;

public interface UserService {

    void save(User user);

    boolean userIsSaved(RegisterRequest registerRequest);
}
