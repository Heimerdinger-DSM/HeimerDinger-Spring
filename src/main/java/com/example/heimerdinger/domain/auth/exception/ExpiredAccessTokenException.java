package com.example.heimerdinger.domain.auth.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class ExpiredAccessTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new ExpiredAccessTokenException();

    private ExpiredAccessTokenException() {
        super(ErrorCode.EXPIRED_ACCESS_TOKEN);
    }
}
