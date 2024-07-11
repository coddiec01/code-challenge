package com.synchrony.codechallenge.service;

import com.synchrony.codechallenge.model.Image;
import com.synchrony.codechallenge.model.User;

import java.util.List;

public interface ImageService {
    Image uploadImage(User user, String imageUrl, String deleteHash);
    Image uploadImage(User user, String imageBase64);
    List<Image> getUserImages(User user);
    void deleteImage(User user, Long imageId);
}
