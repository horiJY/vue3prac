package com.cf.vuestagram.repository;

import com.cf.vuestagram.dto.UserDto;
import com.cf.vuestagram.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private UserMapper mapper;

    public UserRepository(UserMapper mapper) {
        this.mapper = mapper;
    }

    public boolean selectUser(UserDto req) {
//        System.out.println(mapper.selectPosts());

        if (mapper.selectUser(req) != 0)
            return true;
        else
            return false;
    }

    public List<String> findById(String id) {
        return mapper.selectFollower(id);
    }
}
