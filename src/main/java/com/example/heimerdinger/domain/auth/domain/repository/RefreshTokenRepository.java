package com.example.heimerdinger.domain.auth.domain.repository;

import com.example.heimerdinger.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
