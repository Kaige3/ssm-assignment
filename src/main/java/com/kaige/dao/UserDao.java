package com.kaige.dao;

import com.kaige.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@Mapper
public interface UserDao {



    @Select("select * from user where username = #{username}")
    User queryByUsername(String username);
}

