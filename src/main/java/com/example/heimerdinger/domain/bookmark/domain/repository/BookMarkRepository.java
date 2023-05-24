package com.example.heimerdinger.domain.bookmark.domain.repository;

import com.example.heimerdinger.domain.bookmark.domain.BookMark;
import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {
    void deleteByUserAndFeed(User user, Feed feed);
    boolean existsByUserAndFeed(User user, Feed feed);
}
