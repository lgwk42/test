package com.example.serverTest.domain.post.exception.error;

import com.example.serverTest.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostError implements ErrorProperty {

    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다");

    private final HttpStatus status;
    private final String message;

}
