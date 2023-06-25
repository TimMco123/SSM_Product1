package com.xiong.service.impl;

import com.xiong.dao.DeptMapper;
import com.xiong.pojo.Dept;
import com.xiong.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    //查询所有
    @Override
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }

    //根据name查询，是否可用
    @Override
    public boolean checkName(String name) {
        if(deptMapper.getDeptByName(name) != null){
            return false;
        }else{
            return true;
        }
    }

    //根据id查询
    @Override
    public Dept getDeptById(Integer id) {
        return deptMapper.getDeptById(id);
    }

    //添加
    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    //删除
    @Override
    public int delDept(Integer id) {
        return deptMapper.delDept(id);
    }

    //修改
    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }
}
