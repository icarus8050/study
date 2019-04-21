package com.example.junit5withspringboot.repository;

import com.example.junit5withspringboot.Domain.User;

public interface MailClient {
    void sendUserRegistrationMail(User user);
}
