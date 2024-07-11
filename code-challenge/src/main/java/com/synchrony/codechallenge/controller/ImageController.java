package com.synchrony.codechallenge.controller;

import com.synchrony.codechallenge.model.Image;
import com.synchrony.codechallenge.model.User;
import com.synchrony.codechallenge.service.ImageService;
import com.synchrony.codechallenge.service.UserService;
import com.synchrony.codechallenge.util.ImgurApiClient;
import com.synchrony.codechallenge.util.ImgurResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // handles HTTP requests and returns a JSON/XML response
public class ImageController {

    private final ImageService imageService; //immutability for data integrity
    private final UserService userService;
    private final ImgurApiClient imgurApiClient;

    @Autowired // Inject the necessary dependencies into the constructor (ImageController)
    public ImageController(ImageService imageService, UserService userService, ImgurApiClient imgurApiClient) {
        this.imageService = imageService; // initialized
        this.userService = userService;
        this.imgurApiClient = imgurApiClient;
    }

    @PostMapping("/upload") // HTTP POST request
    public Image uploadImage(@RequestParam Long userId, @RequestBody String imageBase64) {
        // Handler method for image upload that retrieves the userId from the request parameters and
        //retrieves the base64-encoded image from the request body
        User user = userService.getUserById(userId); //Fetches userId from UserService, which is a
        // a business logic intermediary between the Controller and JPA
        if (user == null) {
            throw new RuntimeException("User not found"); // If username is empty: throw exception
        }
        ImgurResponse response = imgurApiClient.uploadImage(imageBase64).block(); // Uploads the image to Imgur using
        // the "ImgurAPIClient" and blocks it until the response is received.
        String imageUrl = response.getData().getLink(); // Extracts the URL from the Imgur response
        String deleteHash = response.getData().getDeleteHash(); // Extracts the delete hash from the Imgur response
        return imageService.uploadImage(user, imageUrl, deleteHash); //Uploads the image info to the application
        // and returns the saved image object.
    }

    @GetMapping("/images") // Maps HTTP GET requests to '/images' endpoint
    public List<Image> getUserImages(@RequestParam Long userId) {
        // Handler method created to "get" all images from user
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return imageService.getUserImages(user); // returns a list of images associated with the user.
    }

    @DeleteMapping("/delete") // Maps HTTP DELETE requests to the '/delete' endpoint
    public void deleteImage(@RequestParam Long userId, @RequestParam Long imageId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        } // Retrieves user id and image id
        imageService.deleteImage(user, imageId); // deletes the image with the image id.
    }
}

