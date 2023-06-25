package com.xiong.controller;

import com.xiong.pojo.User;
import com.xiong.pojo.UserInfo;
import com.xiong.service.RewardAndPunishmentService;
import com.xiong.service.UserInfoService;
import com.xiong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private RewardAndPunishmentService rpService;

    //添加职员详情
    @RequestMapping("/addUserInfo")
    public String addUserInfo(UserInfo userInfo, Integer id){
        System.out.println("----UserInfoController----addUserInfo----");
        System.out.println("UserInfo:" + userInfo);
        userInfo.setId(id);
        int total = userInfoService.addUserInfo(userInfo);
        System.out.println("total:" + total);
        return "redirect:/user/getAllUser";
    }

    //查询所有职员详情
    @RequestMapping("/getAllUserInfo")
    public String getAllUserInfo(HttpServletRequest request, HttpSession session){
        System.out.println("----UserInfoController----getAllUserInfo----");
        User user1 = (User) session.getAttribute("user1");
        if(user1.getRole_id() == 1){
            request.setAttribute("userInfoList", userInfoService.getAllUserInfo());
            return "UserInfoList";
        }else{
            request.setAttribute("userInfoList", userInfoService.getUserInfoById1(user1.getId()));
            return "UserInfoList";
        }
    }

    //删除职员
    @RequestMapping("/delUserInfo")
    public String delUser(Integer id){
        System.out.println("----UserController----delUser----");
        System.out.println("id:" + id);
        //调用User表中根据指定id删除
        userService.delUser(id);
        //调用UserInfo表中根据指定id删除
        userInfoService.delUserInfo(id);
        //调用RP奖惩表中根据指定id删除
        rpService.delRPByUserId(id);
        return "redirect:/userInfo/getAllUserInfo";
    }

    //查看单个职员详情
    @RequestMapping("/getUserInfoSingle")
    public String getUserInfoSingle(Integer id, HttpServletRequest request){
        System.out.println("----UserInfoController----getUserInfo----");
        System.out.println("id:" + id);
        request.setAttribute("userInfo", userInfoService.getUserInfoById(id));
        return "UserInfoSingle";
    }

    //修改，根据id查询
    @RequestMapping("/getUserInfo")
    public String getUserInfo(Integer id, HttpServletRequest request){
        System.out.println("----UserInfoController----getUserInfo----");
        System.out.println("id:" + id);
        request.setAttribute("userInfo", userInfoService.getUserInfoById(id));
        return "updateUserInfo";
    }

    //修改单个职员详情信息
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(UserInfo userInfo, HttpServletRequest request){
        System.out.println("----UserInfoController----updateUserInfo----");
        System.out.println("userInfo:" + userInfo);
        request.setAttribute("userInfo", userInfo);
        int total = userInfoService.updateUserInfo(userInfo);
        System.out.println("total:" + total);
        return "forward:/userInfo/getAllUserInfo";
    }
}
