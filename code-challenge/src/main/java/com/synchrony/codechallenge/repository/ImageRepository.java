package com.synchrony.codechallenge.repository;

import com.synchrony.codechallenge.model.Image;
import com.synchrony.codechallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByUser(User user);
}


