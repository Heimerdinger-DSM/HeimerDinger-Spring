package com.example.heimerdinger.domain.like.service;


import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.feed.facade.FeedFacade;
import com.example.heimerdinger.domain.like.domain.Like;
import com.example.heimerdinger.domain.like.domain.repository.LikeRepository;
import com.example.heimerdinger.domain.like.exception.LikeExistsException;
import com.example.heimerdinger.domain.like.facade.LikeFacade;
import com.example.heimerdinger.domain.like.presentation.dto.response.LikeResponse;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AddHeartService {

    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final LikeFacade likeFacade;

    @Transactional
    public LikeResponse execute(UUID feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedId(feedId);

        if (likeFacade.confirmHeart(user, feed)) {
            throw LikeExistsException.EXCEPTION;
        }

        feed.addHeartCount();
        return addHeart(user, feed);
    }

    private LikeResponse addHeart(User user, Feed feed) {
        Like like = Like.builder()
                .user(user)
                .feed(feed)
                .build();
        likeRepository.save(like);

        return LikeResponse.builder()
                .heartCount(feed.getHeartCount())
                .heart(likeFacade.confirmHeart(user, feed))
                .build();
    }
}
