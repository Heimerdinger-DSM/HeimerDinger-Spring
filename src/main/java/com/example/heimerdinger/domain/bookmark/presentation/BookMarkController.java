package com.example.heimerdinger.domain.bookmark.presentation;


import com.example.heimerdinger.domain.bookmark.service.DeleteBookMarkService;
import com.example.heimerdinger.domain.bookmark.service.PostBookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/feeds/bookmark")
@RequiredArgsConstructor
@RestController
public class BookMarkController {
    private final PostBookMarkService postBookMarkService;
    private final DeleteBookMarkService deleteBookMarkService;

    @PostMapping("/{feed-id}")
    public void postBookMark(@PathVariable("feed-id") UUID feedId) {
        postBookMarkService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteBookMark(@PathVariable("feed-id")UUID id) {
        deleteBookMarkService.execute(id);
    }
}
