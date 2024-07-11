package com.synchrony.codechallenge.service;

import com.synchrony.codechallenge.model.Image;
import com.synchrony.codechallenge.model.User;
import com.synchrony.codechallenge.repository.ImageRepository;
import com.synchrony.codechallenge.util.ImgurApiClient;
import com.synchrony.codechallenge.util.ImgurResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ImageServiceTest {

    @MockBean
    private ImageRepository imageRepository;

    @MockBean
    private ImgurApiClient imgurApiClient;

    @Autowired
    private ImageService imageService;

    @Test
    void getUserImages() {
        User user = new User("testuser", "testpass");
        user.setId(user.getId());
        Image image = new Image("http://example.com/image.jpg", "deleteHash", user);
        when(imageRepository.findByUser(user)).thenReturn(Collections.singletonList(image));

        List<Image> images = imageService.getUserImages(user);
        assertEquals(1, images.size());
        assertEquals("http://example.com/image.jpg", images.get(0).getUrl());
    }

    @Test
    void uploadImage() {
        User user = new User("testuser", "testpass");
        user.setId(user.getId());
        ImgurResponse.Data imgurData = new ImgurResponse.Data();
        imgurData.setLink("http://example.com/image.jpg");
        imgurData.setDeleteHash("deleteHash");
        ImgurResponse imgurResponse = new ImgurResponse();
        imgurResponse.setData(imgurData);

        when(imgurApiClient.uploadImage(Mockito.anyString())).thenReturn(Mono.just(imgurResponse));
        when(imageRepository.save(Mockito.any(Image.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Image uploadedImage = imageService.uploadImage(user, "imageBase64");
        assertEquals("http://example.com/image.jpg", uploadedImage.getUrl());
        assertEquals("deleteHash", uploadedImage.getDeleteHash());
    }
}
