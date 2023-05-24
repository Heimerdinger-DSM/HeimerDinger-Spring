package com.example.heimerdinger.domain.auth.presentation;

import com.example.heimerdinger.domain.auth.presentation.dto.request.SignInRequest;
import com.example.heimerdinger.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.heimerdinger.domain.auth.presentation.dto.response.TokenResponse;
import com.example.heimerdinger.domain.auth.service.AuthSignInService;
import com.example.heimerdinger.domain.auth.service.AuthSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthSignUpService authSignUpService;
    private final AuthSignInService authSignInService;

    @PostMapping("/signup")
    public void signUp(@RequestBody SignUpRequest signUpRequest) {
        authSignUpService.execute(signUpRequest);
    }

    @PostMapping("/signin")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest signInRequest) {
        return authSignInService.execute(signInRequest);
    }

}

