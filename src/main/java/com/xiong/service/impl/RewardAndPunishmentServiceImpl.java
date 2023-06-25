package com.xiong.service.impl;

import com.xiong.dao.RewardAndPunishmentMapper;
import com.xiong.pojo.RewardAndPunishment;
import com.xiong.service.RewardAndPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardAndPunishmentServiceImpl implements RewardAndPunishmentService {
    @Autowired
    private RewardAndPunishmentMapper rpMapper;

    //查询所有
    @Override
    public List<RewardAndPunishment> getAllRP() {
        return rpMapper.getAllRP();
    }

    //根据id查询
    @Override
    public RewardAndPunishment getRPById(Integer id) {
        return rpMapper.getRPById(id);
    }

    //根据id查询，返回List
    @Override
    public List<RewardAndPunishment> getRPById1(Integer id) {
        return rpMapper.getRPById1(id);
    }

    //添加
    @Override
    public int addRP(RewardAndPunishment rp) {
        return rpMapper.addRP(rp);
    }

    //删除
    @Override
    public int delRP(Integer id) {
        return rpMapper.delRP(id);
    }

    //根据用户id删除
    @Override
    public int delRPByUserId(Integer user_id) {
        return rpMapper.delRPByUserId(user_id);
    }

    //修改
    @Override
    public int updateRP(RewardAndPunishment rp) {
        return rpMapper.updateRP(rp);
    }
}
