package com.synchrony.codechallenge.repository;

import com.synchrony.codechallenge.model.Image;
import com.synchrony.codechallenge.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ImageRepositoryTest {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUser() {
        User user = new User("testuser", "testpass");
        userRepository.save(user);  // Save the user first

        Image image = new Image("http://example.com/image.jpg", "deleteHash", user);
        imageRepository.save(image);

        List<Image> images = imageRepository.findByUser(user);
        assertEquals(1, images.size());
        assertEquals("http://example.com/image.jpg", images.get(0).getUrl());
    }
}
