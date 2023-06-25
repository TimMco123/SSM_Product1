package com.xiong.service.impl;

import com.xiong.dao.UserMapper;
import com.xiong.pojo.User;
import com.xiong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //登录：查询username和password
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    //查询：查询所有
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    //查询：查询所有，User表，单表
    @Override
    public List<User> getAllUser1() {
        return userMapper.getAllUser1();
    }

    //查询用户名返回id
    @Override
    public int getUsernameReturnId(String username) {
        return userMapper.getUsernameReturnId(username);
    }

    //根据id查询用户，多表
    @Override
    public List<User> getUserById1(Integer id) {
        return userMapper.getUserById1(id);
    }

    //查询当前用户名是否有重复
    @Override
    public boolean checkUsernameRepeat(String username) {
        if(userMapper.getUserByUsername(username) != null){//用户名不可用
            return false;
        }else{//用户名可用
            return true;
        }
    }

    //根据部门号dept_id查询
    @Override
    public List<User> getUserByDeptId(Integer dept_id) {
        return userMapper.getUserByDeptId(dept_id);
    }

    //根据id查询用户
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    //增加
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    //删除
    @Override
    public int delUser(Integer id) {
        return userMapper.delUser(id);
    }

    //修改
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
