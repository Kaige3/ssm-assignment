package com.kaige.service;

import com.kaige.dao.EmpDao;
import com.kaige.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Emp)表服务接口
 *
 * @author makejava
 * @since 2024-12-18 21:53:06
 */
@Service
public class EmpService {

    @Autowired
    private EmpDao empDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Emp queryById(Integer id) {
        return empDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    public int insert(Emp emp) {
        return empDao.insert(emp);
    }

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    public int update(Integer id,Emp emp) {
        return empDao.update(id,emp);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public int deleteById(Integer id) {
        return empDao.deleteById(id);
    }

    public List<Emp> queryByPage() {
        return empDao.queryByPage();
    }

    public List<Emp> queryByNameAndId(String name, Integer sourceId, Integer industryId, Integer gradeId) {
        return empDao.queryByNameAndId(name,sourceId,industryId,gradeId);
    }
}
