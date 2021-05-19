package com.boris.skillbox.diploma.skillbox_diploma.service;

import com.boris.skillbox.diploma.skillbox_diploma.model.entity.User;
import com.boris.skillbox.diploma.skillbox_diploma.repository.UserRepository;
import com.boris.skillbox.diploma.skillbox_diploma.service.interfaces.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
