package com.xiong.controller;

import com.xiong.pojo.*;
import com.xiong.service.*;
import com.xiong.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private JobService jobService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RewardAndPunishmentService rpService;

    //登录
    @RequestMapping("/login")
    public String login(User user, HttpSession session, HttpServletRequest request) {
        System.out.println("----UserController----login----");
        System.out.println("user:" + user);
        User user1 = userService.login(user);
        if (user1 != null) {
            session.setAttribute("user1", user1);
            return "main";
        } else {
            request.setAttribute("msg", "账号、密码、权限可能不正确，请重试");
            return "login";
        }
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("----UserController----logout----");
        session.invalidate();
        return "redirect:/login.jsp";
    }

    //查询所有User
    @RequestMapping("/getAllUser")
    public String getAllUser(HttpServletRequest request, HttpSession session) {
        System.out.println("----UserController----getAllUser----");
        User user1 = (User) session.getAttribute("user1");
        if (user1.getRole_id() == 1) {
            request.setAttribute("userList", userService.getAllUser());
        }else{
            request.setAttribute("userList", userService.getUserById1(user1.getId()));
        }
        return "UserList";
    }

    //添加职员
    @RequestMapping("/addUser")
    @Transactional
    public String addUser(User user, String date, HttpServletRequest request) {
        System.out.println("----UserController----addUser----");
        System.out.println("user:" + user + "\ndate:" + date);
        Date time = DateUtil.getDateByString(date);
        user.setTime(time);
        System.out.println("user:" + user);
        if (userService.checkUsernameRepeat(user.getUsername())) {
            int total = userService.addUser(user);
            System.out.println("total:" + total);
            int id = userService.getUsernameReturnId(user.getUsername());
            System.out.println(id);
            request.setAttribute("userId", id);
            return "AddUserInfo";
        } else {
            request.setAttribute("msg", "用户名不能有重复，请重试");
            request.setAttribute("returnUser", user);
            return "AddUser";
        }
    }

    //删除职员
    @RequestMapping("/delUser")
    public String delUser(Integer id) {
        System.out.println("----UserController----delUser----");
        System.out.println("id:" + id);
        //调用User职员表中根据指定id删除
        userService.delUser(id);
        //调用UserInfo职员详情表中根据指定id删除
        userInfoService.delUserInfo(id);
        //调用RP奖惩表中根据指定id删除
        rpService.delRPByUserId(id);
        return "redirect:/user/getAllUser";
    }

    //判断用户名是否可用
    @RequestMapping("/checkUsernameRepeat")
    @ResponseBody
    public boolean checkUsernameRepeat(String username) {
        System.out.println("----UserController----checkUsernameRepeat----");
        System.out.println("username:" + username);
        return userService.checkUsernameRepeat(username);
    }

    //修改，根据id查询
    @RequestMapping("/getUserById")
    public String getUserById(Integer id, HttpServletRequest request) {
        System.out.println("----UserController----getUserById----");
        System.out.println("id:" + id);
        //根据id查询用户
        User user = userService.getUserById(id);
        System.out.println("user:" + user);
        request.setAttribute("user", user);
        return "updateUser";
    }

    //修改职员信息
    @RequestMapping("/updateUser")
    public String updateUser(User user, String date) {
        System.out.println("----UserController----updateUser----");
        System.out.println("user:" + user + "\ndate:" + date);
        Date time = DateUtil.getDateByString(date);
        user.setTime(time);
        System.out.println("user:" + user);
        int total = userService.updateUser(user);
        System.out.println("total:" + total);
        return "redirect:/user/getAllUser";
    }
}
