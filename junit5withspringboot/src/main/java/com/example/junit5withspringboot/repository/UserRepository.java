package com.example.junit5withspringboot.repository;

import com.example.junit5withspringboot.Domain.User;

public interface UserRepository {
    User insert(User user);
    boolean isUsernameAlreadyExists(String userName);
}
