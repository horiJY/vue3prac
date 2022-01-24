package com.cf.vuestagram.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "user")
public class User {
    @Id
    private String id;
    @Column(nullable = false)
    private String pass;
    private String name;
    private String userimage;

    @OneToMany(mappedBy = "followee", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    private List<Follower> followeeList;

    @OneToMany(mappedBy = "follower", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    private List<Follower> followerList;

    public void setFolloweeList(Follower followee) {
        if (followeeList == null)
            followeeList = new ArrayList<>();
        followeeList.add(followee);
        followee.setFollower(this);
    }

    public void setFollowerList(Follower follower) {
        if (followeeList == null)
            followeeList = new ArrayList<>();
        followeeList.add(follower);
        follower.setFollower(this);
    }
}
