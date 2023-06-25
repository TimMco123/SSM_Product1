package com.xiong.test;

import com.xiong.pojo.UserInfo;
import com.xiong.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-public.xml")
public class UserInfoTest {
    @Autowired
    private UserInfoService userInfoService;

    //添加
    @Test
    public void addUserInfoTest(){
        int total = userInfoService.addUserInfo(new UserInfo("111", "湖北省武汉市", "本科", "测试"));
        System.out.println("total:" + total);
    }

    //删除
    @Test
    public void delUserInfoTest(){
        int total = userInfoService.delUserInfo(7);
        System.out.println("total:" + total);
    }

    //修改
    @Test
    public void updateUserInfoTest(){
        userInfoService.updateUserInfo(new UserInfo(5,"111", "湖北省武汉市", "本科", "测试"));
    }

    //查询所有
    @Test
    public void getAllUserInfoTest(){
        userInfoService.getAllUserInfo().forEach(System.out::println);
    }

    //根据id查询
    @Test
    public void getUserInfoByIdTest(){
        System.out.println(userInfoService.getUserInfoById(1));
        System.out.println(userInfoService.getUserInfoById1(1));
    }
}
