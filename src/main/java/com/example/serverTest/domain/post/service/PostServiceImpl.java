package com.example.serverTest.domain.post.service;

import com.example.serverTest.domain.post.domain.mapper.PostMapper;
import com.example.serverTest.domain.post.domain.repository.PostRepository;
import com.example.serverTest.domain.post.exception.PostNotFoundException;
import com.example.serverTest.domain.post.presentation.dto.Post;
import com.example.serverTest.domain.post.presentation.dto.request.PostEditRequest;
import com.example.serverTest.domain.post.presentation.dto.request.PostRegisterRequest;
import com.example.serverTest.domain.user.dto.User;
import com.example.serverTest.global.jwt.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserSecurity userSecurity;

    @Override
    public void register(PostRegisterRequest request){
        User user = userSecurity.getUser();
        postRepository.save(postMapper.toEntity(request, user.getName()));
    }

    @Override
    public void edit(PostEditRequest request){
        Post post = postRepository
                .findByIdx(request.getIdx())
                .map(postMapper::toPost)
                .orElseThrow(()-> PostNotFoundException.EXCEPTION);
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        postRepository.save(postMapper.toEdit(post));
    }

}
