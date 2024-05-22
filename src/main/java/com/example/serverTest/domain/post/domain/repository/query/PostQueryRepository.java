package com.example.serverTest.domain.post.domain.repository.query;

import com.example.serverTest.domain.post.presentation.dto.Post;
import com.example.serverTest.global.dto.request.PageRequest;

import java.util.List;

public interface PostQueryRepository {
    List<Post> postList(PageRequest request);
}
