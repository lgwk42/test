package com.example.serverTest.domain.post.exception;

import com.example.serverTest.domain.post.exception.error.PostError;
import com.example.serverTest.global.exception.BusinessException;

public class PostNotFoundException extends BusinessException {

    public static final PostNotFoundException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(PostError.POST_NOT_FOUND);
    }

}
