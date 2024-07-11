package com.synchrony.codechallenge.controller;

import com.synchrony.codechallenge.model.User;
import com.synchrony.codechallenge.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc; //injected to perform HTTP request in test case

    @MockBean
    private UserService userService; //Mocks the UserService class using @MockBean

    @Test // JUnit testing
    @WithMockUser // JUnit testing is implemented and runs the testing with a mock authenticated user.
    void getUserById() throws Exception {
        User user = new User("testuser", "testpass");  // Creates test users
        user.setId(1L);
        when(userService.getUserById(user.getId())).thenReturn(user); // Mocks UserService to return to user object from user id

        mockMvc.perform(get("/user?id=1")) // Performs an HTTP GET request to get user info with user id
                .andExpect(status().isOk()) // Conditional expectation: Expects the HTTP response to return 200 OK
                .andExpect(jsonPath("$.username", is("testuser"))); // Verifies user information is returned for the given user ID.
    }

    @Test
    void testUserDetails() {
        User retrievedUser = new User("testuser", "testpass");
        retrievedUser.setId(1L);
        assertEquals("testuser", retrievedUser.getUsername());
        assertEquals(1L, retrievedUser.getId());
    }
}
