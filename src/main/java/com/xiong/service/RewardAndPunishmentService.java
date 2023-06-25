package com.xiong.service;

import com.xiong.pojo.RewardAndPunishment;

import java.util.List;

public interface RewardAndPunishmentService {
    //查询所有
    List<RewardAndPunishment> getAllRP();

    //根据id查询
    RewardAndPunishment getRPById(Integer id);

    //根据id查询，返回List
    List<RewardAndPunishment> getRPById1(Integer id);

    //增加
    int addRP(RewardAndPunishment rp);

    //删除
    int delRP(Integer id);

    //根据用户id删除
    int delRPByUserId(Integer user_id);

    //修改
    int updateRP(RewardAndPunishment rp);
}
