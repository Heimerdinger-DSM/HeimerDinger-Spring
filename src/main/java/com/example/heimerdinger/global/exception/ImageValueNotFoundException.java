package com.example.heimerdinger.global.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class ImageValueNotFoundException extends SnsException {

    public static final SnsException EXCEPTION =
            new ImageValueNotFoundException();

    private ImageValueNotFoundException() {
        super(ErrorCode.IMAGE_VALUE_NOT_FOUND);
    }
}