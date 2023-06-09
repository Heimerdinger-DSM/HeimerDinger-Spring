package com.example.heimerdinger.domain.feed.service;


import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
import com.example.heimerdinger.domain.feed.presentation.dto.response.FeedGetResponse;
import com.example.heimerdinger.domain.image.domain.repository.ImageRepository;
import com.example.heimerdinger.domain.like.facade.LikeFacade;
import com.example.heimerdinger.domain.profile.domain.Profile;
import com.example.heimerdinger.domain.profile.domain.repository.ProfileRepository;
import com.example.heimerdinger.domain.profile.exception.ProfileNotFoundException;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.domain.repository.UserRepository;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedGetService {

    private final LikeFacade likeFacade;
    private final UserFacade userFacade;
    private final FeedRepository feedRepository;
    private final ProfileRepository profileRepository;
    private final ImageRepository imageRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public FeedGetResponse execute() {
        User user = userFacade.getCurrentUser();
        List<FeedGetResponse.FeedResponse> feedResponseList = feedRepository.findAllByJoinFetch()
                .stream()
                .map(feed -> {
                    FeedGetResponse.FeedResponse feedResponse = FeedGetResponse.FeedResponse.builder()
                            .feedUuid(feed.getId())
                            .title(feed.getTitle())
                            .heartCount(feed.getHeartCount())
                            .commentCount(feed.getCommentCount())
                            .createAt(feed.getCreateAt())
                            .name(user.getNickName())
                            .content(feed.getContent())
                            .heartType(likeFacade.confirmHeart(user,feed))
                            .accountId(user.getAccountId())
                            .build();
                    return feedResponse;
                })
                .collect(Collectors.toList());
        return new FeedGetResponse(feedResponseList);

    }

}
