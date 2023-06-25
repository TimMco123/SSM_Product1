package com.xiong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Date time;
    private Integer dept_id;
    private Integer job_id;
    private Integer role_id;

    //个人信息表
    private UserInfo userInfo;

    //部门表
    private Dept dept;

    //职务表
    private Job job;

    //权限表
    private Role role;

    //奖惩表
    private RewardAndPunishment rewardAndPunishment;

    public User(String username, String password, Integer age, Date time, Integer dept_id, Integer job_id, Integer role_id) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.time = time;
        this.dept_id = dept_id;
        this.job_id = job_id;
        this.role_id = role_id;
    }
}
