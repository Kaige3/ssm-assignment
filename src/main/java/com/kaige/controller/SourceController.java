package com.kaige.controller;

import com.kaige.entity.Result;
import com.kaige.entity.Source;
import com.kaige.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Source)表控制层
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    /**
     * 查询所有 source 用于查询框 下拉框展示
     */
    @GetMapping
    public Result<List<Source>> source(){
        List<Source> sourceList = sourceService.queryAll();
        return Result.success(sourceList);
    }


}

