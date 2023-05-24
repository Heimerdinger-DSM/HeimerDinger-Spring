package com.example.heimerdinger.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SnsException extends RuntimeException{

    private final ErrorCode errorCode;
}
