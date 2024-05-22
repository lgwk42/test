package com.example.serverTest.domain.post.service.query;

import com.example.serverTest.domain.post.domain.repository.query.PostQueryRepository;
import com.example.serverTest.domain.post.presentation.dto.Post;
import com.example.serverTest.global.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryServiceImpl implements PostQueryService {

    public final PostQueryRepository postQueryRepository;

    @Override
    public List<Post> postList(PageRequest request) {
        return postQueryRepository.postList(request);
    }

}
