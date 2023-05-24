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
public class FeedDetailResponse {

    @Getter
    @Builder
    public static class FeedGetDetailResponse {
        private UUID feedUuid;

        private String name;

        private String accountId;

        private String title;

        private String content;

        private ZonedDateTime createAt;

        private String category;

        private int heartCount;

        private int commentCount;

        private boolean heartType;

        private List<CommentsResponse> comments;
    }

    @Getter
    @Builder
    public static class CommentsResponse {
        private Long commentId;

        private String name;

        private String content;

        private ZonedDateTime createAt;
    }


}
