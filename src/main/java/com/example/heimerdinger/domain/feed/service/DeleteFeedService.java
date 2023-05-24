package com.example.heimerdinger.domain.feed.service;


import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
import com.example.heimerdinger.domain.feed.exception.FeedNotFoundException;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import com.example.heimerdinger.global.exception.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public void execute(UUID id) {
        User user = userFacade.getCurrentUser();

        Feed feed = feedRepository.findById(id)
                .orElseThrow(()-> FeedNotFoundException.EXCEPTION);

        if(!feed.getUser().equals(user)){
            throw InvalidRoleException.EXCEPTION;
        }
        feedRepository.delete(feed);
        feed.removeCommentCount();
    }
}
