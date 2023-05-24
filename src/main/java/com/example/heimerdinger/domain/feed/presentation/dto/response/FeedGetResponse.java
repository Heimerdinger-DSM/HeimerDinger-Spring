package com.example.heimerdinger.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class FeedGetResponse {

    private final List<FeedResponse> feedResponseList;

    @Getter
    @Builder
    public static class FeedResponse {

        private UUID feedUuid;
        private String name;
        private String title;
        private ZonedDateTime createAt;
        private int heartCount;
        private String accountId;
        private int commentCount;
        private String content;
        private boolean heartType;
    }

}
