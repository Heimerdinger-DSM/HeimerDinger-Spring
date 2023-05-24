package com.example.heimerdinger.domain.profile.domain.repository;


import com.example.heimerdinger.domain.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, String> {
    Optional<Profile> findByUserId(UUID userId);
}
