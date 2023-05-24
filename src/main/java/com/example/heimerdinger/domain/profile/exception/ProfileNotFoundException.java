package com.example.heimerdinger.domain.profile.exception;

import com.example.heimerdinger.global.error.exception.ErrorCode;
import com.example.heimerdinger.global.error.exception.SnsException;

public class ProfileNotFoundException extends SnsException {

    public static final SnsException EXCEPTION=
            new ProfileNotFoundException();

    private ProfileNotFoundException() {
        super(ErrorCode.LIKE_REMOVE_ALREADY_EXISTS);
    }
}
