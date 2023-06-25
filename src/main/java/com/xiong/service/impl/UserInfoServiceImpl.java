package com.xiong.service.impl;

import com.xiong.dao.UserInfoMapper;
import com.xiong.pojo.User;
import com.xiong.pojo.UserInfo;
import com.xiong.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    //添加一条数据
    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.addUserInfo(userInfo);
    }

    //删除
    @Override
    public int delUserInfo(Integer id) {
        return userInfoMapper.delUserInfo(id);
    }

    //修改
    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    //查询所有
    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoMapper.getAllUserInfo();
    }

    //根据id查询
    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.getUserInfoById(id);
    }

    //根据id查询，返回List
    @Override
    public List<UserInfo> getUserInfoById1(Integer id) {
        return userInfoMapper.getUserInfoById1(id);
    }
}
