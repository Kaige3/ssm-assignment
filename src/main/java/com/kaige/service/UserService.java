package com.kaige.service;


import com.kaige.dao.UserDao;
import com.kaige.entity.Result;
import com.kaige.entity.User;
import com.kaige.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String login(String username, String password) {
        User user = userDao.queryByUsername(username);
        if (user == null) {
            // 这里应该写一个自己顶的NotFindUserName,然后全局异常处理器捕获
            // 因为项目比较简单，直接抛出运行异常，程序不会终止就行了
            throw new RuntimeException("用户名不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        return JwtUtils.generateToken(username);
    }
}
