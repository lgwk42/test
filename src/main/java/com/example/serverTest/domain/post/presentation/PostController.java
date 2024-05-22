package com.example.serverTest.domain.post.presentation;

import com.example.serverTest.domain.post.presentation.dto.Post;
import com.example.serverTest.domain.post.presentation.dto.request.PostEditRequest;
import com.example.serverTest.domain.post.presentation.dto.request.PostRegisterRequest;
import com.example.serverTest.domain.post.service.PostService;
import com.example.serverTest.domain.post.service.query.PostQueryService;
import com.example.serverTest.global.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final PostQueryService postQueryService;

    @PostMapping("")
    @ResponseStatus(CREATED)
    public void register(@RequestBody PostRegisterRequest request) {
        postService.register(request);
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> postLIst(@ModelAttribute PageRequest request) {
        return ResponseEntity.ok(postQueryService.postList(request));
    }

    @PatchMapping("")
    public void edit(@RequestBody PostEditRequest request) {
        postService.edit(request);
    }

}
