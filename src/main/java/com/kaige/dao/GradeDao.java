package com.kaige.dao;

import com.kaige.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Grade)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@Mapper
public interface GradeDao {

    @Select("select * from grade")
    List<Grade> queryAll();
}

