package com.example.junit5withspringboot.service;

import com.example.junit5withspringboot.Domain.User;
import com.example.junit5withspringboot.repository.MailClient;
import com.example.junit5withspringboot.repository.SettingRepository;
import com.example.junit5withspringboot.repository.UserRepository;

public class DefaultUserService implements UserService {
    private UserRepository userRepository;
    private SettingRepository settingRepository;
    private MailClient mailClient;

    public DefaultUserService(UserRepository userRepository, SettingRepository settingRepository, MailClient mailClient) {
        this.userRepository = userRepository;
        this.settingRepository = settingRepository;
        this.mailClient = mailClient;
    }

    @Override
    public User register(User user) {
        validate(user);
        User insertedUser = userRepository.insert(user);
        mailClient.sendUserRegistrationMail(insertedUser);
        return insertedUser;
    }

    private void validate(User user) {
        if(user.getName() == null) {
            throw new RuntimeException(Errors.USER_NAME_REQUIRED);
        }

        if(user.getName().length() < settingRepository.getUserNameMinLength()) {
            throw new RuntimeException(Errors.USER_NAME_SHORT);
        }

        if(user.getAge() < settingRepository.getUserMinAge()) {
            throw new RuntimeException(Errors.USER_AGE_YOUNG);
        }

        if(userRepository.isUsernameAlreadyExists(user.getName())) {
            throw new RuntimeException(Errors.USER_NAME_DUPLICATE);
        }
    }
}
