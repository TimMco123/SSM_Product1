package com.xiong.test;

import com.xiong.pojo.User;
import com.xiong.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-public.xml")
public class UserTest {
    @Autowired
    private UserService userService;

    //登录测试
    @Test
    public void loginTest(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        user.setRole_id(1);
        System.out.println(userService.login(user));
    }

    //查询所有
    @Test
    public void getAllUserTest(){
        userService.getAllUser().forEach(System.out::println);
    }

    //查询：查询所有，User表，单表
    @Test
    public void getAllUser1Test(){
        userService.getAllUser1().forEach(System.out::println);

    }
    //根据用户名返回id
    @Test
    public void getUsernameReturnIdTest(){
        System.out.println(userService.getUsernameReturnId("admin"));
    }

    //添加
    @Test
    public void addUserTest(){
        int total = userService.addUser(new User("啊啊啊啊啊啊", "aaaaaaaa", 10, new Date(), 1, 1, 1));
        System.out.println("total:" + total);
    }

    //删除
    @Test
    public void delUserTest(){
        int total = userService.delUser(7);
        System.out.println("total:" + total);
    }

    //查询用户名是否可用
    @Test
    public void checkUsernameRepeatTest(){
        boolean flag = userService.checkUsernameRepeat("admin");
        System.out.println("flag:" + flag);
        if(flag){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名不可用");
        }
    }

    //根据id查询用户
    @Test
    public void getUserByIdTest(){
        System.out.println(userService.getUserById(1));
    }

    //根据id查询用户，多表
    @Test
    public void getUserByIdTest1(){
        System.out.println(userService.getUserById1(1));
    }

    //修改用户
    @Test
    public void updateUserTest(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        user.setRole_id(2);
        user.setId(2);
        int total = userService.updateUser(user);
        System.out.println("total:" + total);
    }

    //根据部门号dept_id查询
    @Test
    public void getUserByDeptIdTest(){
        userService.getUserByDeptId(3).forEach(System.out::println);
    }
}
