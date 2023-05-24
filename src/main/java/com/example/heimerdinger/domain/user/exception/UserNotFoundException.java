package com.example.heimerdinger.domain.user.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class UserNotFoundException extends SnsException {

    public static final SnsException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}