package com.xiong.test;

import com.xiong.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-public.xml")
public class RoleTest {
    @Autowired
    private RoleService roleService;

    //查询所有
    @Test
    public void getAllRoleTest(){
        roleService.getAllRole().forEach(System.out::println);
    }
}
