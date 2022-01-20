package com.cf.vuestagram.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String name;
    private String content;
    private String date;
    private String filter;
    private boolean liked;
    private Integer likes;
    private String postimage;
    private String userimage;

    public PostDto(Long id){
        this.id = id;
    }
}
