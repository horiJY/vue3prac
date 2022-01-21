package com.cf.vuestagram.mapper;

import com.cf.vuestagram.dto.UserAuthDto;
import com.cf.vuestagram.dto.FollowDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT count(* ) " +
            "FROM USER " +
            "WHERE ID = #{id} " +
            "AND PASS = #{password}")
    int selectUser(UserAuthDto req);

    @Select("SELECT id, userimage " +
            "FROM USER " +
            "WHERE id != #{id}")
    List<FollowDto> selectFollowers(String id);
}

