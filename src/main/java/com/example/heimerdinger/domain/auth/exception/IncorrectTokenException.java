package com.example.heimerdinger.domain.auth.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class IncorrectTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new IncorrectTokenException();

    private IncorrectTokenException() {
        super(ErrorCode.INCORRECT_TOKEN);
    }
}
