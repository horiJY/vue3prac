package com.cf.vuestagram.controller;

import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.PostDto;
import com.cf.vuestagram.dto.UserDto;
import com.cf.vuestagram.service.VuestaService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VuestaController {
    private final VuestaService vuestaService;

    @GetMapping("/post")
    public List<PostDto> postList(){
        log.info("GET /post");
        return vuestaService.findPost();
    }

    @PostMapping("/post")
    public PostDto postAdd(@RequestBody CreatePostDto req){
        log.info("POST /post add");
        return vuestaService.addPost(req);
    }

    @PostMapping("/signin")
    public boolean userAuth(@RequestBody UserDto req){
        log.info("POST /signin");
        return vuestaService.findUser(req);
    }

    @PostMapping("/follwer")
    public List<String> followerListFind(@RequestBody String id){
        log.info("Post /follower");
        return vuestaService.findFollower(id);
    }


}