package com.synchrony.codechallenge.service;

import com.synchrony.codechallenge.model.User;
import com.synchrony.codechallenge.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void getUserById() {
        User user = new User("testuser", "testpass");
        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));

        User found = userService.getUserById(user.getId());
        assertEquals("testuser", found.getUsername());
    }
}
