package com.synchrony.codechallenge.controller;

import com.synchrony.codechallenge.model.Image;
import com.synchrony.codechallenge.model.User;
import com.synchrony.codechallenge.service.ImageService;
import com.synchrony.codechallenge.service.UserService;
import com.synchrony.codechallenge.util.ImgurApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(ImageController.class) // @WebMvcTest initializes only the ImageController and not the entire application
public class ImageControllerTest {

    @Autowired
    private MockMvc mockMvc; // Injected to perform HTTP request in test case

    @MockBean
    private ImageService imageService; // Mocks the ImageService class @MockBean

    @MockBean
    private UserService userService; // Mocks the UserService class using @MockBean

    @MockBean
    private ImgurApiClient imgurApiClient;

    @Test // JUnit testing
    @WithMockUser // JUnit testing is implemented and runs the testing with a mock authenticated user.
    void getUserImages() throws Exception {
        User user = new User("testuser", "testpass"); // Creates test users
        user.setId(1L); // Ensure the user ID is set to a known value
        Image image = new Image("http://example.com/image.jpg", "deleteHash", user); // Creates test image
        when(userService.getUserById(user.getId())).thenReturn(user); // Mocks the behavior of user service to return the user with user id.
        when(imageService.getUserImages(user)).thenReturn(Collections.singletonList(image)); // Mocks the behavior of the image service to return a list containing the image when called with the user instance.

        mockMvc.perform(get("/images?userId=1")) // Performs an HTTP GET request to get image matching the user id.
                .andExpect(status().isOk()) // Conditional expectation: Expects the HTTP response to return 200 OK
                .andExpect(jsonPath("$", hasSize(1))) // Conditional expectation: JSON response is expected to be a list of size 1
                .andExpect(jsonPath("$[0].url", is("http://example.com/image.jpg"))); // Conditional expectation: Expects the URL of the first image in JSON response to be equivalent to "http://example.com/image.jpg"
    }

    @Test
    void testImageDetails() {
        User user = new User("testuser", "testpass");
        user.setId(1L); // Ensure the user ID is set to a known value
        Image image = new Image("http://example.com/image.jpg", "deleteHash", user); // Creates test image

        // Assert the properties of the image
        assertEquals("http://example.com/image.jpg", image.getUrl());
        assertEquals("deleteHash", image.getDeleteHash());
        assertEquals(user, image.getUser());
        assertEquals(1L, user.getId());
        assertEquals("testuser", user.getUsername());
    }
}
