package com.xiong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RewardAndPunishment {
    private Integer id;
    private Integer type;
    private String detail;
    private Date time;
    private Integer user_id;

    private User user;

    private RPType rpType;
}
