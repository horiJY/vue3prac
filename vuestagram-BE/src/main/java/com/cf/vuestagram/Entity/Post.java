package com.cf.vuestagram.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


@Entity(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String postimage;
    private String filter;
    private String content;
    private String date;
    @ColumnDefault("0")
    private Integer likes;
    @ColumnDefault("false")
    private boolean liked;
}
