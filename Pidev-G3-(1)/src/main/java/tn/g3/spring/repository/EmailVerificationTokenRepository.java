package tn.g3.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.g3.spring.entity.token.EmailVerificationToken;

import java.util.Optional;

public interface EmailVerificationTokenRepository extends JpaRepository<EmailVerificationToken, Long> {

    Optional<EmailVerificationToken> findByToken(String token);
}
