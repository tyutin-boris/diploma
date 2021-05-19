package com.boris.skillbox.diploma.skillbox_diploma.service.interfaces;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;

public interface UserService {

    User findById(long id);

    void save(User user);
}
