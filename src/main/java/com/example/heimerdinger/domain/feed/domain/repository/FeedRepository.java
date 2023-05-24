package com.example.heimerdinger.domain.feed.domain.repository;

import com.example.heimerdinger.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeedRepository extends CrudRepository<Feed, UUID> {

    @Query("select f from Feed f join fetch f.user order by f.CreateAt DESC ")
    List<Feed> findAllByJoinFetch();

    Optional<Feed> findById(UUID id);


}
