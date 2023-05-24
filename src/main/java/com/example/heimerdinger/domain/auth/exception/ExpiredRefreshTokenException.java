package com.example.heimerdinger.domain.auth.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class ExpiredRefreshTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new ExpiredRefreshTokenException();

    private ExpiredRefreshTokenException() {
        super(ErrorCode.EXPIRED_REFRESH_TOKEN);
    }
}
