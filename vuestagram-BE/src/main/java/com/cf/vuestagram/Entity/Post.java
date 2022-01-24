package com.cf.vuestagram.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    // private String postimage;
    private String mediatype;
    private String url;
    private String filter;
    private String content;
    private String date;
    @ColumnDefault("0")
    private Integer likes;
    @ColumnDefault("false")
    private boolean liked;
}
