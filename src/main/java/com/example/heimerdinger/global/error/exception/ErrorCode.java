package com.example.heimerdinger.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {


    SAVE_IMAGE_FAILED(400, "COMMON-400-1", "Save Image Failed"),
    IMAGE_VALUE_NOT_FOUND(400, "COMMON-404-1", "Image Value Not Found"),
    LIKE_ALREADY_EXISTS(409, "LIKE-409-1", "Like Already Exists"),
    LIKE_REMOVE_ALREADY_EXISTS(409, "LIKE-409-1", "Like Remove Already Exists"),
    EXPIRED_JWT(401, "COMMON-401-1", "Expired Jwt"),
    INVALID_JWT(401, "COMMON-401-2", "Invalid Jwt"),
    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error"),
    EXPIRED_ACCESS_TOKEN(401, "AUTH-401-1", "Expired Access Token"),
    EXPIRED_REFRESH_TOKEN(401, "AUTH-401-1", "Expired Refresh Token"),
    INVALID_ROLE(401, "GLOBAL-401-1", "Invalid Role"),
    INVALID_TOKEN(401, "AUTH-401-1", "Invalid Token"),
    INCORRECT_TOKEN(500, "AUTH-500-1", "Incrrect Token"),
    INVALID_PASSWORD(401, "USER-4o1-1", "Invalid Passowrd"),
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    FEED_NOT_FOUND(404, "FEED-404-1", "Feed Not Found"),
    PROFILE_NOT_FOUND(404, "PROFILE-404-1", "Profile Not Found"),
    IMAGE_NOT_FOUND(404, "IMAGE-404-1", "Image Not Found"),
    FORBIDDEN(403, "COMMON-403-1", "Forbidden");

    private final int status;
    private final String code;
    private final String message;
}
