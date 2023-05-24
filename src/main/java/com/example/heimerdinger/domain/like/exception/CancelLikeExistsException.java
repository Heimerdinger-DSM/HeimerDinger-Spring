package com.example.heimerdinger.domain.like.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class CancelLikeExistsException extends SnsException {

    public static final SnsException EXCEPTION =
            new CancelLikeExistsException();

    private CancelLikeExistsException() {
        super(ErrorCode.LIKE_REMOVE_ALREADY_EXISTS);
    }
}
