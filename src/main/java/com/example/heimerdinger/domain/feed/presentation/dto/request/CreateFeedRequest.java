package com.example.heimerdinger.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    private String title;

    private String content;

    private String category;

    private List<String> url;
}
