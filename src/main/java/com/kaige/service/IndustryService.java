package com.kaige.service;

import com.kaige.dao.IndustryDao;
import com.kaige.entity.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Industry)表服务接口
 *
 * @author makejava
 * @since 2024-12-18 21:53:07
 */
@Service
public class IndustryService {

    @Autowired
    private IndustryDao industryDao;

    public List<Industry> queryAll() {
        return industryDao.queryAll();
    }
}
