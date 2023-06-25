package com.xiong.test;

import com.xiong.service.Job_levelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-public.xml")
public class Job_levelTest {
    @Autowired
    private Job_levelService job_levelService;

    //查询所有
    @Test
    public void getAllTest(){
        job_levelService.getAll().forEach(System.out::println);
    }
}
