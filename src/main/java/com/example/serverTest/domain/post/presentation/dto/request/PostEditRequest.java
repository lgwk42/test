package com.example.serverTest.domain.post.presentation.dto.request;

import lombok.Getter;

@Getter
public class PostEditRequest {

    private Long idx;
    private String title;
    private String content;

}
