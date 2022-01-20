package com.cf.vuestagram.repository;

import com.cf.vuestagram.Entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface FollowRepository extends JpaRepository<Follower, String> {
    public Boolean findByFolloweeIdAndFollowerId(String followeeId, String followerId);

    @Modifying
    @Transactional
    public void deleteByFolloweeIdAndFollowerId(String followeeId, String followerId);
}
