package com.kaige.service;

import com.kaige.dao.SourceDao;
import com.kaige.entity.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Source)表服务接口
 *
 * @author makejava
 * @since 2024-12-18 21:53:07
 */
@Service
public class SourceService {

    @Autowired
    private SourceDao sourceDao;

    public List<Source> queryAll() {
        return sourceDao.queryAll();
    }
}
