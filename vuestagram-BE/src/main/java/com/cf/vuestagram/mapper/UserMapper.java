package com.cf.vuestagram.mapper;

import com.cf.vuestagram.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT count(* ) " +
            "FROM USER " +
            "WHERE ID = #{id} " +
            "AND PASS = #{password}")
    int selectUser(UserDto req);

    @Select("SELECT follower " +
            "FROM FOLLOWER " +
            "WHERE user = #{id}")
    List<String> selectFollower(String id);
}

