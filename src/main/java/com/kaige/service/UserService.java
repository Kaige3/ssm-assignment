package com.kaige.service;


import com.kaige.dao.UserDao;
import com.kaige.entity.Result;
import com.kaige.entity.User;
import com.kaige.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-12-18 21:53:07
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public Result login(String username, String password) {
        User user = userDao.queryByUsername(username);
        if (user == null) {
            return Result.error("用户名不存在");
        }
        if (!user.getPassword().equals(password)) {
            return Result.error("密码错误");
        }
        String token = JwtUtils.generateToken(username);
        // 直接把用户信息和token返回给前端，省事，少写一个接口
        HashMap<String, Object> map = new HashMap<>(8);
        map.put("token", token);
        map.put("userinfo", user);
        return Result.success(map);
    }
}
