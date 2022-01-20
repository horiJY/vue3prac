package com.cf.vuestagram.repository;

import com.cf.vuestagram.Entity.Post;
import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.PostDto;
import com.cf.vuestagram.mapper.PostMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PostRepository {
    private PostMapper mapper;

    public PostRepository(PostMapper mapper) {
        this.mapper = mapper;
    }

    public List<PostDto> findAll() {
//        System.out.println(mapper.selectPosts());
        return mapper.selectAllPost();
    }

    @Transactional
    public PostDto save(CreatePostDto req) {
        mapper.insertPost(req); // 수행 후 post테이블 max(id)값 받아옴
        PostDto res = new PostDto(req.getId());
        return mapper.selectPost(res.getId());
    }
}
