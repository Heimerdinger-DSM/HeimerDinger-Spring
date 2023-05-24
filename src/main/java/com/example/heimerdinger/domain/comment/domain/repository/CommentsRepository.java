package com.example.heimerdinger.domain.comment.domain.repository;

import com.example.heimerdinger.domain.comment.domain.Comments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface CommentsRepository extends CrudRepository<Comments, Long> {

    List<Comments> findAllByFeedId(UUID id);
}
