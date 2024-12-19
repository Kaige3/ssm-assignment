package com.kaige.service;

import com.kaige.dao.GradeDao;
import com.kaige.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Grade)表服务接口
 *
 * @author makejava
 * @since 2024-12-18 21:53:07
 */
@Service
public class GradeService {

    @Autowired
    private GradeDao gradeDao;


   public List<Grade> queryAll() {
       return gradeDao.queryAll();
    }
}
