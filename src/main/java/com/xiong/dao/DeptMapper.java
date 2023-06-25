package com.xiong.dao;

import com.xiong.pojo.Dept;

import java.util.List;

public interface DeptMapper {
    //查询所有
    List<Dept> getAllDept();

    //根据name查询
    Dept getDeptByName(String name);

    //根据id查询
    Dept getDeptById(Integer id);

    //添加
    int addDept(Dept dept);

    //删除
    int delDept(Integer id);

    //修改
    int updateDept(Dept dept);
}
