package com.example.serverTest.domain.user.domain.repository;

import com.example.serverTest.domain.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    UserEntity getByEmail(String email);

}
