package com.example.heimerdinger.global.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class InvalidJwtException extends SnsException {

    public static final SnsException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
