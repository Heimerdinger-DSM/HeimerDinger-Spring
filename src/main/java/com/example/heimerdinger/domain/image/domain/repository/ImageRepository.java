package com.example.heimerdinger.domain.image.domain.repository;

import com.example.heimerdinger.domain.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
    List<Image> findAllByFeedId(UUID feedId);
}
