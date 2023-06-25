package com.xiong.service;

import com.xiong.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    //添加一条数据
    int addUserInfo(UserInfo userInfo);

    //删除
    int delUserInfo(Integer id);

    //修改
    int updateUserInfo(UserInfo userInfo);

    //查询所有
    List<UserInfo> getAllUserInfo();

    //根据id查询
    UserInfo getUserInfoById(Integer id);

    //根据id查询，返回List
    List<UserInfo> getUserInfoById1(Integer id);
}
