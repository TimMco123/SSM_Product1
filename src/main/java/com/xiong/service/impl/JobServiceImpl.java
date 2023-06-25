package com.xiong.service.impl;

import com.xiong.dao.JobMapper;
import com.xiong.pojo.Job;
import com.xiong.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;

    //查询所有
    @Override
    public List<Job> getAllJob() {
        return jobMapper.getAllJob();
    }

    //根据id查询
    @Override
    public Job getJobById(Integer id) {
        return jobMapper.getJobById(id);
    }

    //根据id查询，返回List
    @Override
    public List<Job> getJobById1(Integer id) {
        return jobMapper.getJobById1(id);
    }

    //检查name是否可用
    @Override
    public boolean checkJobName(String name) {
        if(jobMapper.getJobByName(name) != null){
            return false;
        }else{
            return true;
        }
    }

    //添加
    @Override
    public int addJob(Job job) {
        return jobMapper.addJob(job);
    }

    //删除
    @Override
    public int delJob(Integer id) {
        return jobMapper.delJob(id);
    }

    //修改
    @Override
    public int updateJob(Job job) {
        return jobMapper.updateJob(job);
    }
}
