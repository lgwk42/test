package com.example.serverTest.domain.post.domain.mapper;

import com.example.serverTest.domain.post.domain.PostEntity;
import com.example.serverTest.domain.post.presentation.dto.Post;
import com.example.serverTest.domain.post.presentation.dto.request.PostEditRequest;
import com.example.serverTest.domain.post.presentation.dto.request.PostRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostEntity toEntity(PostRegisterRequest request, String author) {
        return PostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(author)
                .build();
    }

    public PostEntity toEdit(Post request) {
        return PostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public Post toPost(PostEntity postEntity) {
        return Post.builder()
                .idx(postEntity.getIdx())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .author(postEntity.getAuthor())
                .build();
    }

}
