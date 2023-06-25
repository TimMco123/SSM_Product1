package com.xiong.service;

import com.xiong.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询所有
    List<Dept> getAllDept();

    //根据name查询，是否可用
    boolean checkName(String name);

    //根据id查询
    Dept getDeptById(Integer id);

    //添加
    int addDept(Dept dept);

    //删除
    int delDept(Integer id);

    //修改
    int updateDept(Dept dept);
}
