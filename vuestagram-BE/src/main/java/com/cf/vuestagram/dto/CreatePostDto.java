package com.cf.vuestagram.dto;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CreatePostDto {
    private Long id;
    @NotNull
    private String writer;
    private String mediatype;
    // private MultipartFile[] files;
    private String url;
    private String filter;
    private String content;
    private String date;
}
