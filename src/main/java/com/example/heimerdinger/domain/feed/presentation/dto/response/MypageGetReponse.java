package com.example.heimerdinger.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class MypageGetReponse {

    @Getter
    @Builder
    public static class MyPageGetDetailResponse {
        private String name;

        private String accountId;

        private List<feedResponse> feeds;

        private List<heartsResponse> hearts;
    }

    @Getter
    @Builder
    public static class feedResponse {
        private Long feedId;

        private String name;

        private String accountId;

        private String content;

        private ZonedDateTime createAt;

        private int heartCount;

        private boolean heartType;

        private String category;
    }

    @Getter
    @Builder
    public static class heartsResponse {
        private Long feedId;

        private String name;

        private String accountId;

        private String content;

        private ZonedDateTime createAt;

        private int heartCount;

        private boolean heartType;

        private String category;
    }
}
