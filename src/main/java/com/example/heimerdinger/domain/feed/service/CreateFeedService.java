package com.example.heimerdinger.domain.feed.service;

import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
import com.example.heimerdinger.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.heimerdinger.domain.image.domain.Image;
import com.example.heimerdinger.domain.image.domain.repository.ImageRepository;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final ImageRepository imageRepository;

    @Transactional
    public void execute(CreateFeedRequest createFeedRequest) {
        User user = userFacade.getCurrentUser();

        Feed feed = Feed.builder()
                .title(createFeedRequest.getTitle())
                .user(user)
                .category(createFeedRequest.getCategory())
                .content(createFeedRequest.getContent())
                .build();
        feedRepository.save(feed);

        for (String i : createFeedRequest.getUrl()) {
            Image image = Image.builder()
                    .feed(feed)
                    .url(i)
                    .build();
            imageRepository.save(image);
        }
    }
}
