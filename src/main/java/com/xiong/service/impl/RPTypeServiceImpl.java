package com.xiong.service.impl;

import com.xiong.dao.RPTypeMapper;
import com.xiong.pojo.RPType;
import com.xiong.service.RPTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RPTypeServiceImpl implements RPTypeService {
    @Autowired
    private RPTypeMapper rpTypeMapper;

    //查询所有
    @Override
    public List<RPType> getAllRPT() {
        return rpTypeMapper.getAllRPT();
    }
}
