package com.example.heimerdinger.domain.profile.domain;


import com.example.heimerdinger.domain.user.domain.User;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Table(name = "profileTbl")
@Entity
public class Profile {

    @Id
    @Column(columnDefinition = "VARCHAR(5)")
    private String name;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    private String introduce;

    @NotNull
    @Column(columnDefinition = "VARCHAR(300)")
    private String photo;

    @NotNull
    private String link;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Profile(String name, String introduce, String photo, String link, User user) {
        this.name = name;
        this.introduce = introduce;
        this.link = link;
        this.photo = photo;
        this.user = user;
    }


}
