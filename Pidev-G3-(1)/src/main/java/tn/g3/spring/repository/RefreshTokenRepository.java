package tn.g3.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.g3.spring.entity.token.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Override
    Optional<RefreshToken> findById(Long id);

    Optional<RefreshToken> findByToken(String token);

}

