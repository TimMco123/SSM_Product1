package com.xiong.test;

import com.xiong.pojo.RewardAndPunishment;
import com.xiong.service.RewardAndPunishmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-public.xml")
public class RewardAndPunishmentTest {
    @Autowired
    private RewardAndPunishmentService rpService;

    //查询所有
    @Test
    public void getAllRPTest(){
        rpService.getAllRP().forEach(System.out::println);
    }

    //根据id查询所有
    @Test
    public void getRPById(){
        System.out.println(rpService.getRPById(1));
    }

    //添加
    @Test
    public void addRPTest(){
        RewardAndPunishment rp = new RewardAndPunishment();
        rp.setType(2);
        rp.setDetail("test");
        rp.setTime(new Date());
        rp.setUser_id(3);
        int total = rpService.addRP(rp);
        System.out.println("total:" + total);
    }

    //删除
    @Test
    public void delRP(){
        int total = rpService.delRP(1);
        System.out.println("total:" + total);
    }

    //修改
    @Test
    public void updateRPTest(){
        RewardAndPunishment rp = new RewardAndPunishment();
        rp.setId(2);
        rp.setType(1);
        rp.setDetail("test1111");
        rp.setTime(new Date());
        int total = rpService.updateRP(rp);
        System.out.println("total:" + total);
    }
}
