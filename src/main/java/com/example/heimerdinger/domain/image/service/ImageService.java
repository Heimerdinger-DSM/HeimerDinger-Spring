package com.example.heimerdinger.domain.image.service;

import com.example.heimerdinger.domain.image.presentation.dto.response.ImageUrlResponse;
import com.example.heimerdinger.global.annotation.ServiceWithTransactionalReadOnly;
import com.example.heimerdinger.infrastructure.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ServiceWithTransactionalReadOnly
public class ImageService {

    private final S3Facade s3Facade;

    public ImageUrlResponse execute(List<MultipartFile> images) {
        List<String> imageUrl = images.stream()
                .map(s3Facade::uploadImage)
                .collect(Collectors.toList());

        return new ImageUrlResponse(imageUrl);
    }
}
