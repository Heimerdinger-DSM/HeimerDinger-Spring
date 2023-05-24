package com.example.heimerdinger.domain.like.domain.repository;

import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.like.domain.Like;
import com.example.heimerdinger.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Long> {

    boolean existsByUserAndFeed(User user, Feed feed);

    void deleteByUserAndFeed(User user, Feed feed);
}
