package com.example.heimerdinger.domain.image.domain;


import com.example.heimerdinger.domain.feed.domain.Feed;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "PhotoTbl")
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @NotNull
    @Column(columnDefinition = "VARCHAR(300)")
    private String url;

    @Builder
    public Image (Feed feed, String url) {
        this.feed = feed;
        this.url = url;
    }
}
