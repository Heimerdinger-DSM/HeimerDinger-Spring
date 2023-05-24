package com.example.heimerdinger.domain.comment.service;


import com.example.heimerdinger.domain.comment.domain.Comments;
import com.example.heimerdinger.domain.comment.domain.repository.CommentsRepository;
import com.example.heimerdinger.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CreateCommentsService {

    private final CommentsRepository commentRepository;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateCommentRequest createCommentRequest, UUID id) {
        User user = userFacade.getCurrentUser();

        Feed feed = feedRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        Comments comments = Comments.builder()
                .user(user)
                .feed(feed)
                .content(createCommentRequest.getContent())
                .build();
        commentRepository.save(comments);

        feed.addCommentCount();
    }
}
