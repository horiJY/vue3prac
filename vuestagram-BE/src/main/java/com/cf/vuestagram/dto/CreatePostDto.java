package com.cf.vuestagram.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CreatePostDto {
    private Long id;
    @NotNull
    private String user;
    private String postimage;
    private String filter;
    private String content;
    private String date;
}
