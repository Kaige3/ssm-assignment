package com.kaige.controller;

import com.kaige.entity.Industry;
import com.kaige.entity.Result;
import com.kaige.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Industry)表控制层
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@RestController
@RequestMapping("industry")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    /**
     * 查询所有 industry 用于查询框 下拉框展示
     */
    @GetMapping
    public Result<List<Industry>> industry(){
        List<Industry> industryList = industryService.queryAll();
        return Result.success(industryList);
    }



}

