package com.example.junit5withspringboot.service;

import com.example.junit5withspringboot.Domain.User;
import com.example.junit5withspringboot.repository.MailClient;
import com.example.junit5withspringboot.repository.SettingRepository;
import com.example.junit5withspringboot.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class UserServiceTest {
    UserService userService;
    SettingRepository settingRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    MailClient mailClient;

    User user;

    @BeforeEach
    void init(@Mock SettingRepository settingRepository) {
        userService = new DefaultUserService(userRepository, settingRepository, mailClient);
        lenient().when(settingRepository.getUserMinAge()).thenReturn(10);
        when(settingRepository.getUserNameMinLength()).thenReturn(4);
        lenient().when(userRepository.isUsernameAlreadyExists(any(String.class))).thenReturn(false);
        this.settingRepository = settingRepository;
    }

    @Test
    void givenValidUser_whenSaveUser_thenSucceed(@Mock MailClient mailClient) {
        // Given
        user = new User("Jerry", 12);
        when(userRepository.insert(any(User.class))).then(new Answer<User>() {
            int sequence = 1;

            @Override
            public User answer(InvocationOnMock invocation) throws Throwable {
                User user = (User) invocation.getArgument(0);
                user.setId(sequence++);
                return user;
            }
        });

        userService = new DefaultUserService(userRepository, settingRepository, mailClient);

        // When
        User insertedUser = userService.register(user);

        // Then
        verify(userRepository).insert(user);
        Assertions.assertNotNull(user.getId());
        verify(mailClient).sendUserRegistrationMail(insertedUser);
    }

    @Test
    void givenShortName_whenSaveUser_thenGiveShortUsernameError() {
        // Given
        user = new User("tom", 12);

        // When
        try {
            userService.register(user);
            fail("Should give an error");
        } catch(Exception ex) {
            assertEquals(ex.getMessage(), Errors.USER_NAME_SHORT);
        }

        // Then
        verify(userRepository, never()).insert(user);
    }

    @Test
    void givenSmallAge_whenSaveUser_thenGiveYoungUserError() {
        // Given
        user = new User("jerry", 3);

        // When
        try {
            userService.register(user);
            fail("Should give an error");
        } catch(Exception ex) {
            assertEquals(ex.getMessage(), Errors.USER_AGE_YOUNG);
        }

        // Then
        verify(userRepository, never()).insert(user);
    }

    @Test
    void givenUserWithExistingName_whenSaveUser_thenGiveUsernameAlreadyExistsError() {
        // Given
        user = new User("jerry", 12);
        Mockito.reset(userRepository);
        when(userRepository.isUsernameAlreadyExists(any(String.class))).thenReturn(true);

        // When
        try {
            userService.register(user);
            fail("Should give an error");
        } catch(Exception ex) {
            assertEquals(ex.getMessage(), Errors.USER_NAME_DUPLICATE);
        }

        // Then
        verify(userRepository, never()).insert(user);
    }
}