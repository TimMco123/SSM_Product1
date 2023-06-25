package com.xiong.service.impl;

import com.xiong.dao.Job_levelMapper;
import com.xiong.pojo.Job_level;
import com.xiong.service.Job_levelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Job_levelServiceImpl implements Job_levelService {
    @Autowired
    private Job_levelMapper job_levelMapper;

    @Override
    public List<Job_level> getAll() {
        return job_levelMapper.getAll();
    }
}
