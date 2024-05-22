package com.example.serverTest.domain.post.service;

import com.example.serverTest.domain.post.presentation.dto.request.PostEditRequest;
import com.example.serverTest.domain.post.presentation.dto.request.PostRegisterRequest;

public interface PostService {
    void register(PostRegisterRequest request);

    void edit(PostEditRequest request);
}
