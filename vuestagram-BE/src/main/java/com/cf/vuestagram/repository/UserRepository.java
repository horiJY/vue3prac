package com.cf.vuestagram.repository;

import com.cf.vuestagram.dto.UserAuthDto;
import com.cf.vuestagram.dto.FollowDto;
import com.cf.vuestagram.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {
    private UserMapper mapper;

    public UserRepository(UserMapper mapper) {
        this.mapper = mapper;
    }

    public boolean selectUser(UserAuthDto req) {
//        System.out.println(mapper.selectPosts());

        if (mapper.selectUser(req) != 0)
            return true;
        else
            return false;
    }

    public List<FollowDto> findById(String req) {
        return mapper.selectFollowers(req);
    }
}
