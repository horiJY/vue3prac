package com.cf.vuestagram.controller;

import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.FollowDto;
import com.cf.vuestagram.dto.PostDto;
import com.cf.vuestagram.dto.UserAuthDto;
import com.cf.vuestagram.service.VuestaService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public boolean userAuth(@RequestBody UserAuthDto req){
        log.info("POST /signin");
        return vuestaService.findUser(req);
    }

    @PostMapping("/follower")
    public List<FollowDto> followerListFind(@RequestBody Map<String,String> id){
        log.info("Post /follower");
        return vuestaService.findFollower(id.get("id"));
    }


}