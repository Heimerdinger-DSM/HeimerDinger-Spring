package com.example.heimerdinger.domain.bookmark.service;

import com.example.heimerdinger.domain.bookmark.domain.repository.BookMarkRepository;
import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.feed.facade.FeedFacade;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import com.example.heimerdinger.global.exception.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class DeleteBookMarkService {
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final BookMarkRepository bookMarkRepository;

    @Transactional
    public void execute(UUID id) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedId(id);

        if (!feed.getUser().equals(user)) {
            throw InvalidRoleException.EXCEPTION;
        }

        bookMarkRepository.deleteByUserAndFeed(user, feed);

    }
}
