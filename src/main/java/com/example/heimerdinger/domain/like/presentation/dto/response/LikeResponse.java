package com.example.heimerdinger.domain.like.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class LikeResponse {
    private int heartCount;
    private boolean heart;
}
