package com.kaige.controller;

import com.kaige.entity.Grade;
import com.kaige.entity.Result;
import com.kaige.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Grade)表控制层
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@RestController
@RequestMapping("grade")
public class GradeController {
    /**
     * 服务对象
     */
    @Autowired
    private GradeService gradeService;

    /**
     * 查询所有 grage 用于查询框 下拉框展示
     */
    @GetMapping
    public Result<List<Grade>> grade(){
        List<Grade> gradeList = gradeService.queryAll();
        return Result.success(gradeList);
    }


}

