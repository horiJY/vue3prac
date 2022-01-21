package com.cf.vuestagram.service;

import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.PostDto;
import com.cf.vuestagram.dto.UserDto;
import com.cf.vuestagram.repository.FollowRepository;
import com.cf.vuestagram.repository.PostRepository;
import com.cf.vuestagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VuestaService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public List<PostDto> findPost() {
        return postRepository.findAll();
    }

    public PostDto addPost(CreatePostDto req) {
         return postRepository.save(req);
    }

    public boolean findUser(UserDto req) {
        return userRepository.selectUser(req);
    }

    public List<String> findFollower(String id) {return userRepository.findById(id);
    }

    public boolean checkFollower(String followeeId, String followerId){
        if(followRepository.findByFolloweeIdAndFollowerId(followeeId,followerId)){
            return false;
        }
        return true;
    }

    public void deleteByFolloweeIdAndFollowerId(String followeeId, String followerId ){
        followRepository.deleteByFolloweeIdAndFollowerId(followeeId,followerId);
    }

}
