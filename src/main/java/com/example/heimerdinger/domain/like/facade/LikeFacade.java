package com.example.heimerdinger.domain.like.facade;

import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.like.domain.repository.LikeRepository;
import com.example.heimerdinger.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {
    private final LikeRepository likeRepository;

    public boolean confirmHeart(User user, Feed feed) {
        return likeRepository.existsByUserAndFeed(user, feed);
    }
}
