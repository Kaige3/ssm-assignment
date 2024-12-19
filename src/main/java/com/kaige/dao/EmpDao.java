package com.kaige.dao;

import com.kaige.entity.Emp;
import com.kaige.entity.vo.EmpVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Emp)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-18 21:51:27
 */
@Mapper
public interface EmpDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from emp where id = #{id}")
    Emp queryById(Integer id);



    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 影响行数
     */
    @Insert("insert into emp (name,linkman,phone,telephone,postal_code,address, grade_id, source_id, industry_id) values (#{name}, #{linkman}, #{phone},#{telephone},#{postalCode},#{address}, #{gradeId}, #{sourceId}, #{industryId})")
    int insert(Emp emp);


    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 影响行数
     */
    @Update("update emp set name = #{emp.name}, linkman = #{emp.linkman}, phone = #{emp.phone}, telephone = #{emp.telephone}, postal_code = #{emp.postalCode}, address = #{emp.address}, grade_id = #{emp.gradeId}, source_id = #{emp.sourceId}, industry_id = #{emp.industryId} where id = #{id}")
    int update(@Param("id") Integer id,@Param("emp") Emp emp);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from emp where id = #{id}")
    int deleteById(Integer id);

//    @Select("select * from emp")
    List<EmpVo> queryByPage();

    List<EmpVo> queryByNameAndId(@Param("name") String name, @Param("sourceId") Integer sourceId, @Param("industryId") Integer industryId, @Param("gradeId") Integer gradeId);
}

