package com.example.heimerdinger.global.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class SaveImageFailedException extends SnsException {

    public static final SnsException EXCEPTION =
            new SaveImageFailedException();

    private SaveImageFailedException() {
        super(ErrorCode.SAVE_IMAGE_FAILED);
    }
}