package com.kaige.controller;


import com.kaige.entity.Result;
import com.kaige.entity.User;
import com.kaige.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-12-18 21:51:29
 */
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @PostMapping("login")
    public Result login(String username,String password) {
        String login = userService.login(username, password);
        return Result.success(login);
    }


}

