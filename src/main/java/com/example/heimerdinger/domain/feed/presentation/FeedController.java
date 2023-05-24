package com.example.heimerdinger.domain.feed.presentation;

import com.example.heimerdinger.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.heimerdinger.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.example.heimerdinger.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.example.heimerdinger.domain.feed.presentation.dto.response.FeedGetResponse;
import com.example.heimerdinger.domain.feed.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final DeleteFeedService deleteFeedService;
    private final UpdateFeedService updateFeedService;
    private final FeedGetService feedGetService;
    private final FeedGetDetailService feedGetDetailService;

    @GetMapping("/list")
    public FeedGetResponse getFeed() {
        return feedGetService.execute();
    }
    @GetMapping("/{id}")
    public FeedDetailResponse.FeedGetDetailResponse getFeedDetail(@PathVariable UUID id) {
        return feedGetDetailService.execute(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable UUID id) {
        deleteFeedService.execute(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    public void updateFeed(@PathVariable UUID id, @RequestBody UpdateFeedRequest request) {
        updateFeedService.execute(id, request);
    }



}
