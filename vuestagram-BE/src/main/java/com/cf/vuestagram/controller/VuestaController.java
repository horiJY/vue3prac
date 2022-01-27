package com.cf.vuestagram.controller;

import java.util.List;
import java.util.Map;

import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.FollowDto;
import com.cf.vuestagram.dto.PostDto;
import com.cf.vuestagram.dto.UserAuthDto;
import com.cf.vuestagram.service.VuestaService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VuestaController {
    private final VuestaService vuestaService;

    @GetMapping("/post")
    public List<PostDto> postListSearch() {
        log.info("GET /post");
        return vuestaService.findPost();
    }

    @PostMapping(value = "/post", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public PostDto postCreate(
            @RequestPart(value = "postDto") CreatePostDto req,
            @RequestPart(value = "files", required = false) List<MultipartFile> files) {
        log.info("POST /post add");
        // log.info("{}", req);

        return vuestaService.addPost(req, files);
    }

    @PostMapping("/signin")
    public boolean userAuth(@RequestBody UserAuthDto req) {
        log.info("POST /signin");
        return vuestaService.findUser(req);
    }

    @PostMapping("/follower")
    public List<FollowDto> followerListSearch(@RequestBody Map<String, String> id) {
        log.info("Post /follower");
        return vuestaService.findFollower(id.get("id"));
    }

    @GetMapping(value = "/image/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] imageSearch(@PathVariable String name) throws Exception {

        return vuestaService.findImage(name);
    }

}