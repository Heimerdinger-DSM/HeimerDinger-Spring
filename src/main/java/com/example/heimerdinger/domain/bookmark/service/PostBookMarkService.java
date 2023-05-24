package com.example.heimerdinger.domain.bookmark.service;

import com.example.heimerdinger.domain.bookmark.domain.BookMark;
import com.example.heimerdinger.domain.bookmark.domain.repository.BookMarkRepository;
import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
import com.example.heimerdinger.domain.feed.exception.FeedNotFoundException;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostBookMarkService {

    private final FeedRepository feedRepository;
    private final BookMarkRepository bookMarkRepository;
    private final UserFacade userFacade;


    @Transactional
    public void execute(UUID id) {
        User user = userFacade.getCurrentUser();

        Feed feed = feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        BookMark bookMark = BookMark.builder()
                .feed(feed)
                .user(user)
                .build();
        bookMarkRepository.save(bookMark);
    }

}
