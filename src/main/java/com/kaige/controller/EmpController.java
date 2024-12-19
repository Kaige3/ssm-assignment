package com.kaige.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaige.entity.Emp;
import com.kaige.entity.Result;
import com.kaige.entity.vo.EmpVo;
import com.kaige.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Emp)表控制层
 *
 * @author makejava
 * @since 2024-12-18 21:51:26
 */
@RestController
@RequestMapping("emp")
public class EmpController {
    /**
     * 服务对象
     */
    @Autowired
    private EmpService empService;

    /**
     * 分页查询
     */
    @GetMapping("page/{pageNum}/{pageSize}")
    public Result<PageInfo<EmpVo>> queryByPage(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpVo> empList = empService.queryByPage();
        PageInfo<EmpVo> empPageInfo = new PageInfo<>(empList);
        return Result.success(empPageInfo);

    }

    /**
     * 通过主键查询单条数据 测试通过
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<Emp> queryById(@PathVariable("id") Integer id) {
        Emp emp = empService.queryById(id);
        return Result.success(emp);
    }

    /**
     * 新增数据
     *
     * @param emp 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<Emp> add(@RequestBody Emp emp) {
        int insert = empService.insert(emp);
        if (insert > 0) {
            return Result.success(200,"新增成功");
        }else{
            return Result.error(500,"新增失败");
        }
    }

    /**
     * 编辑数据 测试通过
     *
     * @param emp 实体
     * @return 编辑结果
     */
    @PutMapping("update/{id}")
    public Result edit(@PathVariable("id")Integer id, @RequestBody Emp emp) {
        int update = empService.update(id,emp);
        if (update > 0) {
            return Result.success(200, "修改成功");
        } else {
            return Result.error(500, "修改失败");
        }
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(@RequestParam Integer id) {
        int count = empService.deleteById(id);
        if (count > 0) {
            return Result.success(200,"删除成功");
        }else{
            return Result.error(500,"删除失败");
        }
    }

    /**
     * 根据name,id 动态查询
     */
    @GetMapping("/search")
    public Result<PageInfo<EmpVo>> queryByNameAndId(@RequestParam(required = false) String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false) Integer sourceId, @RequestParam(required = false) Integer industryId, @RequestParam(required = false) Integer gradeId) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpVo> empList = empService.queryByNameAndId(name, sourceId, industryId, gradeId);
        PageInfo<EmpVo> empPageInfo = new PageInfo<>(empList);
        return Result.success(empPageInfo);
    }

}

