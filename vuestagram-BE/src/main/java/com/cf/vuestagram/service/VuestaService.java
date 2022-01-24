package com.cf.vuestagram.service;

import java.util.List;

import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.FollowDto;
import com.cf.vuestagram.dto.PostDto;
import com.cf.vuestagram.dto.UserAuthDto;
import com.cf.vuestagram.repository.FollowRepository;
import com.cf.vuestagram.repository.PostRepository;
import com.cf.vuestagram.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VuestaService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    // private final CommentRepository commentRepository;

    public List<PostDto> findPost() {
        // List<PostDto> posts = postRepository.findAll();
        // for (PostDto n : posts){
        // List<CommentDto> comments = commentRepository.findByPostId(n.getId());
        // }
        return postRepository.findAll();
    }

    public PostDto addPost(CreatePostDto req) {
        return postRepository.save(req);
    }

    public boolean findUser(UserAuthDto req) {
        return userRepository.findByUserId(req);
    }

    public List<FollowDto> findFollower(String req) {
        return userRepository.findById(req);
    }

    public boolean checkFollower(String followeeId, String followerId) {
        if (followRepository.findByFolloweeIdAndFollowerId(followeeId, followerId)) {
            return false;
        }
        return true;
    }

    public void deleteByFolloweeIdAndFollowerId(String followeeId, String followerId) {
        followRepository.deleteByFolloweeIdAndFollowerId(followeeId, followerId);
    }

}
