package com.example.heimerdinger.domain.auth.service;

import com.example.heimerdinger.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest signUpRequest) {
        userRepository.save(
                User.builder()
                        .nickName(signUpRequest.getNickName())
                        .password(passwordEncoder.encode(signUpRequest.getPassword()))
                        .accountId(signUpRequest.getAccountId())
                        .build());
    }
}
