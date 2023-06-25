package com.xiong.test;

import com.xiong.pojo.Dept;
import com.xiong.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-public.xml")
public class DeptTest {
    @Autowired
    private DeptService deptService;

    //查询所有
    @Test
    public void getAllDeptTest(){
        deptService.getAllDept().forEach(System.out::println);
    }

    //添加
    @Test
    public void addDeptTest(){
        int total = deptService.addDept(new Dept());
        System.out.println("total:" + total);
    }

    //检查name是否可用
    @Test
    public void checkDeptName(){
        if(deptService.checkName("财务部")){
            System.out.println("可用");
        }else{
            System.out.println("不可用");
        }
    }

    //根据id查询
    @Test
    public void getDeptById(){
        System.out.println(deptService.getDeptById(2));
    }

    //删除
    @Test
    public void delDeptTest(){
        int total = deptService.delDept(6);
        System.out.println("total:" + total);
    }

    //修改
    @Test
    public void updateDeptTest(){
        Dept dept = new Dept(2,"无");
        deptService.updateDept(dept);
    }
}
