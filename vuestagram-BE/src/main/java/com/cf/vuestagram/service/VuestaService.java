package com.cf.vuestagram.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.FollowDto;
import com.cf.vuestagram.dto.PostDto;
import com.cf.vuestagram.dto.UserAuthDto;
import com.cf.vuestagram.repository.FollowRepository;
import com.cf.vuestagram.repository.PostRepository;
import com.cf.vuestagram.repository.UserRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class VuestaService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    // private final CommentRepository commentRepository;

    @Value("${image.base.dir}")
    private String baseDir;

    public List<PostDto> findPost() {
        // List<PostDto> posts = postRepository.findAll();
        // for (PostDto n : posts){
        // List<CommentDto> comments = commentRepository.findByPostId(n.getId());
        // }
        return postRepository.findAll();
    }

    public PostDto addPost(CreatePostDto req, List<MultipartFile> files) {
        for (MultipartFile file : files) {
            if (req.getUrl() == null)
                req.setUrl(file.getOriginalFilename());
            else
                req.setUrl(req.getUrl() + "," + file.getOriginalFilename());

            Path downloadPath = Paths.get(baseDir + file.getOriginalFilename());
            try {
                file.transferTo(downloadPath);
            } catch (Exception e) {
                log.warn(e);
            }
        }

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

    public void deletePost(String followeeId, String followerId) {
        followRepository.deleteByFolloweeIdAndFollowerId(followeeId, followerId);
    }

}
