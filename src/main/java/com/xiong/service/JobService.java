package com.xiong.service;

import com.xiong.pojo.Job;

import java.util.List;

public interface JobService {
    //查询所有
    List<Job> getAllJob();

    //根据id查询
    Job getJobById(Integer id);

    //根据id查询，返回List
    List<Job> getJobById1(Integer id);

    //检查name是否可用
    boolean checkJobName(String name);

    //添加
    int addJob(Job job);

    //删除
    int delJob(Integer id);

    //修改
    int updateJob(Job job);
}
