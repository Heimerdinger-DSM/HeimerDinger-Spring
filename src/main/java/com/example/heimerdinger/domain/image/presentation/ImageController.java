package com.example.heimerdinger.domain.image.presentation;

import com.example.heimerdinger.domain.image.presentation.dto.response.ImageUrlResponse;
import com.example.heimerdinger.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/feeds/image")
@RestController
public class ImageController {

    private final ImageService imageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ImageUrlResponse saveImage(@RequestPart List<MultipartFile> images) {
        return imageService.execute(images);
    }

}
