package com.example.heimerdinger.domain.user.facade;

import com.example.heimerdinger.domain.user.domain.User;
import com.example.heimerdinger.domain.user.domain.repository.UserRepository;
import com.example.heimerdinger.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByAccountId(accountId);
    }

    public User getUserByAccountId(String id) {
        return userRepository.findByAccountId(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
