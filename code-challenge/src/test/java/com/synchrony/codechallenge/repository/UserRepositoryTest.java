package com.synchrony.codechallenge.repository;

import com.synchrony.codechallenge.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername() {
        User user = new User("testuser", "testpass");
        userRepository.save(user);

        User found = userRepository.findByUsername("testuser");
        assertEquals("testuser", found.getUsername());
    }
}
