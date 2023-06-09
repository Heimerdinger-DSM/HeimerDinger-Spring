package com.example.heimerdinger.domain.feed.service;


import com.example.heimerdinger.domain.bookmark.domain.repository.BookMarkRepository;
import com.example.heimerdinger.domain.comment.domain.repository.CommentsRepository;
import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
import com.example.heimerdinger.domain.feed.exception.FeedNotFoundException;
import com.example.heimerdinger.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.example.heimerdinger.domain.image.domain.repository.ImageRepository;
import com.example.heimerdinger.domain.like.facade.LikeFacade;
import com.example.heimerdinger.domain.profile.domain.Profile;
import com.example.heimerdinger.domain.profile.domain.repository.ProfileRepository;
import com.example.heimerdinger.domain.profile.exception.ProfileNotFoundException;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedGetDetailService {

    private final LikeFacade likeFacade;
    private final UserFacade userFacade;
    private final FeedRepository feedRepository;
    private final ProfileRepository profileRepository;
    private final ImageRepository imageRepository;
    private final CommentsRepository commentsRepository;
    private final BookMarkRepository bookMarkRepository;

    @Transactional(readOnly = true)
    public FeedDetailResponse.FeedGetDetailResponse execute(UUID id) {
        User user = userFacade.getCurrentUser();
        return feedRepository.findById(id)
                .map(feed -> {
                    FeedDetailResponse.FeedGetDetailResponse feedGetDetailResponse = FeedDetailResponse.FeedGetDetailResponse.builder()
                            .feedUuid(feed.getId())
                            .name(user.getNickName())
                            .accountId(user.getAccountId())
                            .title(feed.getTitle())
                            .content(feed.getContent())
                            .createAt(feed.getCreateAt())
                            .category(feed.getCategory())
                            .heartCount(feed.getHeartCount())
                            .commentCount(feed.getCommentCount())
                            .heartType(likeFacade.confirmHeart(user, feed))
                            .comments(commentsRepository.findAllByFeedId(feed.getId()).stream().map(comments -> FeedDetailResponse.CommentsResponse.builder()
                                    .commentId(comments.getId())
                                    .content(comments.getContent())
                                    .name(user.getNickName())
                                    .createAt(comments.getCreateAt())
                                    .build()).collect(Collectors.toList()))
                            .build();
                    return feedGetDetailResponse;
                })
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

    }
}