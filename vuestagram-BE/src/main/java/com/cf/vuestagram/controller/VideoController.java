package com.cf.vuestagram.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class VideoController {
    // private String url = "보여줄 비디오 url 경로";

    @GetMapping(value = "/video/{name}")
    public ResponseEntity<ResourceRegion> getVideo(@RequestHeader HttpHeaders headers, @PathVariable String name)
            throws IOException {
        // try {
        log.info("VideoController.getVideo");
        UrlResource video = new UrlResource(
                "file:C:\\Users\\JY\\Desktop\\code\\vuesta-video\\" + name + ".mp4");
        final long chunkSize = 1024 * 1024;
        long contentLength = video.contentLength();
        Optional<HttpRange> optional = headers.getRange().stream().findFirst();
        ResourceRegion resourceRegion;
        HttpRange httpRange;

        if (optional.isPresent()) {
            httpRange = optional.get();
            long start = httpRange.getRangeStart(contentLength);
            long end = httpRange.getRangeEnd(contentLength);
            long rangeLength = Long.min(chunkSize, end - start + 1);
            resourceRegion = new ResourceRegion(video, start, rangeLength);
            log.info("-resourceRegion(inner if): " + resourceRegion.toString());
            log.info("-httpRange: " + httpRange);
        } else {
            long rangeLength = Long.min(chunkSize, contentLength);
            resourceRegion = new ResourceRegion(video, 0, rangeLength);
            log.info("rangeLength:" + rangeLength);
            log.info("-resourceRegion(inner else): " + resourceRegion.toString());
        }
        log.info("return", ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(
                        MediaTypeFactory.getMediaType(video).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(resourceRegion));
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(
                        MediaTypeFactory.getMediaType(video).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(resourceRegion);
        // } catch (Exception e) {
        // log.warn(e.getMessage());
        // }

    }

}
