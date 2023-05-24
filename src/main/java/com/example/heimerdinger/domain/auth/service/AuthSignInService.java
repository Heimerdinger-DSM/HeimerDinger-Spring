package com.example.heimerdinger.domain.auth.service;


import com.example.heimerdinger.domain.auth.exception.InvalidPasswordException;
import com.example.heimerdinger.domain.auth.presentation.dto.request.SignInRequest;
import com.example.heimerdinger.domain.auth.presentation.dto.response.TokenResponse;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.domain.repository.UserRepository;
import com.example.heimerdinger.domain.user.exception.UserNotFoundException;
import com.example.heimerdinger.global.annotation.ServiceWithTransactionalReadOnly;
import com.example.heimerdinger.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@ServiceWithTransactionalReadOnly
public class AuthSignInService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse execute(SignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getAccountId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

}
