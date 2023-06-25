package com.xiong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Integer id;
    private String telephone;
    private String address;
    private String education;
    private String work;

    private User user;

    public UserInfo(String telephone, String address, String education, String work) {
        this.telephone = telephone;
        this.address = address;
        this.education = education;
        this.work = work;
    }

    public UserInfo(Integer id, String telephone, String address, String education, String work) {
        this.id = id;
        this.telephone = telephone;
        this.address = address;
        this.education = education;
        this.work = work;
    }
}
