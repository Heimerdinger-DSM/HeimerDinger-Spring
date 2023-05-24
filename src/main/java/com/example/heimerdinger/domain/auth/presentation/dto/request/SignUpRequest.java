package com.example.heimerdinger.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    private String accountId;

    private String nickName;

    private String password;

}
