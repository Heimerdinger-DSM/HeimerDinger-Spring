package com.example.heimerdinger.domain.user.domain;


import com.example.heimerdinger.global.enums.Authority;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "UserTbl")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    private String accountId;

    @NotNull
    @Column(columnDefinition = "VARCHAR(320)")
    private String nickName;

    @NotNull
    @Column(columnDefinition = "VARCHAR(60)")
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String nickName, String accountId, String password) {
        this.nickName = nickName;
        this.accountId = accountId;
        this.password = password;
        this.authority = Authority.USER;
    }

}
