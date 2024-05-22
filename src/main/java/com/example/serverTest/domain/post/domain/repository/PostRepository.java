package com.example.serverTest.domain.post.domain.repository;

import com.example.serverTest.domain.post.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    Optional<PostEntity> findByIdx(Long idx);

}
