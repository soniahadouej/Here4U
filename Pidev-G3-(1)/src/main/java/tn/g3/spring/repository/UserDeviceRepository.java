package tn.g3.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.g3.spring.entity.UserDevice;
import tn.g3.spring.entity.token.RefreshToken;

import java.util.Optional;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {

    @Override
    Optional<UserDevice> findById(Long id);

    Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken);

    Optional<UserDevice> findByUserId(Long userId);
}
