package com.example.heimerdinger.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateFeedRequest {

    private String content;

    private String title;

    private String email;

    private String url;
}
