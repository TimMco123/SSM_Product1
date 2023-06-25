package com.xiong.service;

import com.xiong.pojo.User;

import java.util.List;

public interface UserService {
    //登录：查询username和password
    User login(User user);

    //查询：查询所有
    List<User> getAllUser();

    //查询：查询所有，User表，单表
    List<User> getAllUser1();

    //查询用户名返回id
    int getUsernameReturnId(String username);

    //查询当前用户名是否有重复
    boolean checkUsernameRepeat(String username);

    //根据id查询用户信息
    User getUserById(Integer id);

    //根据id查询用户信息，多表
    List<User> getUserById1(Integer id);

    //根据部门号dept_id查询
    List<User> getUserByDeptId(Integer dept_id);

    //增加
    int addUser(User user);

    //删除
    int delUser(Integer id);

    //修改
    int updateUser(User user);
}
