package com.cf.vuestagram.mapper;

import java.util.List;

import com.cf.vuestagram.dto.FollowDto;
import com.cf.vuestagram.dto.UserAuthDto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
