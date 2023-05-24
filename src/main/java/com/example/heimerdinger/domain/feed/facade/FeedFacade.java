package com.example.heimerdinger.domain.feed.facade;

import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
import com.example.heimerdinger.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeedId(UUID feedId) {
        return feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
