package com.cf.vuestagram.controller;

import java.io.IOException;

import com.cf.vuestagram.service.VideoService;

import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VideoController {
        private final VideoService videoService;

        @GetMapping(value = "/video/{name}")
        public ResponseEntity<ResourceRegion> videoSearch(@RequestHeader HttpHeaders headers, @PathVariable String name)
                        throws IOException {
                // log.info("GET /video/" + name);

                return videoService.findVideo(headers, name);
        }

}
