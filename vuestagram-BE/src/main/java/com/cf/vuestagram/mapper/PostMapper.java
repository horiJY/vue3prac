package com.cf.vuestagram.mapper;

import java.util.List;

import com.cf.vuestagram.dto.CreatePostDto;
import com.cf.vuestagram.dto.PostDto;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface PostMapper {

        @Select("SELECT P.ID, WRITER, CONTENT, DATE, FILTER, LIKED, LIKES, MEDIATYPE,URL, USERIMAGE " +
                        "FROM POST P " +
                        "JOIN USER U " +
                        "WHERE P.WRITER = U.ID")
        List<PostDto> selectAllPost();

        @Select("SELECT P.ID, WRITER, CONTENT, DATE, FILTER, LIKED, LIKES, MEDIATYPE,URL, USERIMAGE " +
                        "FROM POST P " +
                        "JOIN USER U " +
                        "WHERE P.WRITER = U.ID " +
                        "AND P.ID = #{id}")
        PostDto selectPost(Long id);

        @Insert("INSERT INTO post(user, mediatype, url, filter, content, date) VALUES (#{user}, #{mediatype}, #{url}, #{postimage},#{filter},#{content},#{date})")
        @SelectKey(statement = "SELECT MAX(id) from POST", keyProperty = "id", before = false, resultType = Long.class)
        int insertPost(CreatePostDto req);

}
