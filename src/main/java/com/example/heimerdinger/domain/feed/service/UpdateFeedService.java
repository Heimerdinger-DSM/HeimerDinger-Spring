package com.example.heimerdinger.domain.feed.service;

import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
import com.example.heimerdinger.domain.feed.exception.FeedNotFoundException;
import com.example.heimerdinger.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import com.example.heimerdinger.global.exception.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public void execute(UUID id, UpdateFeedRequest updateFeedRequest) {
        User user = userFacade.getCurrentUser();

        Feed feed = feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        if (!feed.getUser().equals(user)) {
            throw InvalidRoleException.EXCEPTION;
        }

        feed.updateFeed(updateFeedRequest.getTitle(), updateFeedRequest.getContent(), updateFeedRequest.getEmail(), updateFeedRequest.getUrl());
    }
}

