package com.xiong.test;

import com.xiong.pojo.Job;
import com.xiong.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-public.xml")
public class JobTest {
    @Autowired
    private JobService jobService;

    //查询所有
    @Test
    public void getAllJobTest(){
        jobService.getAllJob().forEach(System.out::println);
    }

    //根据id查询
    @Test
    public void getJobById(){
        System.out.println(jobService.getJobById(2));
    }

    //根据id查询，返回List
    @Test
    public void getJobById1(){
        System.out.println(jobService.getJobById1(2));
    }

    //根据name查询
    @Test
    public void checkJobName(){
        if(jobService.checkJobName("广告")){
            System.out.println("name可用");
        }else{
            System.out.println("name不可用");
        }
    }
    //删除
    @Test
    public void delJobTest(){
        jobService.delJob(2);
    }

    //修改
    @Test
    public void updateJobTest(){
        jobService.updateJob(new Job(2,"test",0.0,1));
    }
}
