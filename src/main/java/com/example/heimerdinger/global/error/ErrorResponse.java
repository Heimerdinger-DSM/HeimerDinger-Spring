package com.example.heimerdinger.global.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ErrorResponse {
    private final int status;
    private final String code;
    private final String message;
}