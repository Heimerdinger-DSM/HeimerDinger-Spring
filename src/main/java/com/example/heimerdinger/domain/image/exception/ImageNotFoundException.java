package com.example.heimerdinger.domain.image.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class ImageNotFoundException extends SnsException {

    public static final ImageNotFoundException EXCEPTION =
            new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }
}
