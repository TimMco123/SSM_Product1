package com.xiong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private Integer id;
    private String name;
    private Double salary;
    private Integer level;

    //职务等级表
    private Job_level job_level;

    //用户表
    private User user;

    public Job(Integer id, String name, Double salary, Integer level) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.level = level;
    }
}
