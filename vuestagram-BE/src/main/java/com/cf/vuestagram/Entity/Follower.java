package com.cf.vuestagram.Entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Entity(name="follower")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follower {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="followee")
    private User followee;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "follower")
    private User follower;

}
