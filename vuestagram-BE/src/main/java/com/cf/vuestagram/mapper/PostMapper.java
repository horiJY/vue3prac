package com.cf.vuestagram.mapper;

import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.PostDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("SELECT P.ID, NAME, CONTENT, DATE, FILTER, LIKED, LIKES, POSTIMAGE, USERIMAGE " +
            "FROM POST P " +
            "JOIN USER U " +
            "WHERE P.USER = U.ID")
    List<PostDto> selectAllPost();

    @Select("SELECT P.ID, NAME, CONTENT, DATE, FILTER, LIKED, LIKES, POSTIMAGE, USERIMAGE " +
            "FROM POST P " +
            "JOIN USER U " +
            "WHERE P.USER = U.ID " +
            "AND P.ID = #{id}")
    PostDto selectPost(Long id);

    @Insert("INSERT INTO post(user, postimage, filter, content, date) VALUES (#{user},#{postimage},#{filter},#{content},#{date})")
    @SelectKey(statement = "SELECT MAX(id) from POST", keyProperty = "id", before = false, resultType = Long.class)
    int insertPost(CreatePostDto req);


}

