package com.synchrony.codechallenge.service;

import com.synchrony.codechallenge.model.Image;
import com.synchrony.codechallenge.model.User;
import com.synchrony.codechallenge.repository.ImageRepository;
import com.synchrony.codechallenge.util.ImgurApiClient;
import com.synchrony.codechallenge.util.ImgurResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ImgurApiClient imgurApiClient;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, ImgurApiClient imgurApiClient) {
        this.imageRepository = imageRepository;
        this.imgurApiClient = imgurApiClient;
    }

    @Override
    public Image uploadImage(User user, String imageUrl, String deleteHash) {
        Image image = new Image(imageUrl, deleteHash, user);
        return imageRepository.save(image);
    }

    @Override
    public Image uploadImage(User user, String imageBase64) {
        Mono<ImgurResponse> responseMono = imgurApiClient.uploadImage(imageBase64);
        ImgurResponse response = responseMono.block(); // handle response properly

        if (response != null && response.getData() != null) {
            String imageUrl = response.getData().getLink();
            String deleteHash = response.getData().getDeleteHash();
            return uploadImage(user, imageUrl, deleteHash);
        }
        throw new RuntimeException("Failed to upload image to Imgur");
    }

    @Override
    public List<Image> getUserImages(User user) {
        return imageRepository.findByUser(user);
    }

    @Override
    public void deleteImage(User user, Long imageId) {
        Image image = imageRepository.findById(imageId).orElse(null);
        if (image != null && image.getUser().equals(user)) {
            imgurApiClient.deleteImage(image.getDeleteHash()).block();
            imageRepository.delete(image);
        }
    }
}

