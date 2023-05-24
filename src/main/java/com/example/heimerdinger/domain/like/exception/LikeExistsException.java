package com.example.heimerdinger.domain.like.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class LikeExistsException extends SnsException {

    public static final SnsException EXCEPTION =
            new LikeExistsException();

    private LikeExistsException() {
        super(ErrorCode.LIKE_ALREADY_EXISTS);
    }
}
