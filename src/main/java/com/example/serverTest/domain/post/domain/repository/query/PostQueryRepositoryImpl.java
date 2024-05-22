package com.example.serverTest.domain.post.domain.repository.query;

import com.example.serverTest.domain.post.presentation.dto.Post;
import com.example.serverTest.global.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.serverTest.domain.post.domain.QPostEntity.postEntity;

@Repository
@RequiredArgsConstructor
public class PostQueryRepositoryImpl implements PostQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> postList(PageRequest request){
        return jpaQueryFactory
                .select(postConstructorExpression())
                .from(postEntity)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(postEntity.idx.asc())
                .fetch();
    }

    private ConstructorExpression<Post> postConstructorExpression(){
        return Projections.constructor(Post.class,
                postEntity.idx,
                postEntity.title,
                postEntity.content,
                postEntity.author
        );
    }

}
