package com.example.heimerdinger.domain.comment.domain;


import com.example.heimerdinger.domain.feed.domain.Feed;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.global.entity.BaseTimeEntity;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Table(name = "CommentTbl")
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    private String content;

    @Builder
    public Comments(String content, Feed feed, User user) {
        this.content = content;
        this.feed = feed;
        this.user = user;
    }

    public void updateComments(String content) {
        this.content = content;
    }
}
