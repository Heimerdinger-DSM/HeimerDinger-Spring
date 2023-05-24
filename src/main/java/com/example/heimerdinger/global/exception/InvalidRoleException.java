package com.example.heimerdinger.global.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class InvalidRoleException extends SnsException {

    public static final SnsException EXCEPTION =
            new InvalidRoleException();

    private InvalidRoleException() {
        super(ErrorCode.INVALID_ROLE);
    }
}
