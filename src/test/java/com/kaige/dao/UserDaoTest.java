//package com.kaige.dao;
//
//import com.kaige.model.entity.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)  // 启用 Spring 的 JUnit 运行器
//@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})  // 指定 Spring 配置文件路径
//public class UserDaoTest {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Test
//    public void findAllUsers() {
//        List<User> allUsers = userDao.findAllUsers();
//        for (User user : allUsers) {
//            System.out.println(user);
//        }
//    }
//}
