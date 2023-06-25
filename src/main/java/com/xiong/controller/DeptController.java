package com.xiong.controller;

import com.xiong.pojo.Dept;
import com.xiong.pojo.Job;
import com.xiong.pojo.Role;
import com.xiong.pojo.User;
import com.xiong.service.DeptService;
import com.xiong.service.UserInfoService;
import com.xiong.service.UserService;
import com.xiong.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private UserService userService;

    //查询所有
    @RequestMapping("/getAllDept")
    public String getAllDept(HttpServletRequest request){
        System.out.println("----DeptController----getAllDept----");
        request.setAttribute("deptList", deptService.getAllDept());
        return "DeptList";
    }

    //查询name是否可用
    @RequestMapping("/checkDeptName")
    @ResponseBody
    public boolean checkDeptName(String name){
        System.out.println("----DeptController----checkDeptName----");
        return deptService.checkName(name);
    }

    //添加
    @RequestMapping("/addDept")
    public String addDept(Dept dept, HttpServletRequest request){
        System.out.println("----DeptController----addDept----");
        if(deptService.checkName(dept.getName())){
            deptService.addDept(dept);
            return "redirect:/dept/getAllDept";
        }else{
            request.setAttribute("returnDeptName", dept.getName());
            request.setAttribute("msg", "部门名不能有重复，请重试");
            return "AddDept";
        }
    }

    //删除
    @RequestMapping("/delDept")
    public String delDept(Integer id){
        System.out.println("----DeptController----delDept----");
        System.out.println("id:" + id);
        deptService.delDept(id);
        return "redirect:/dept/getAllDept";
    }

    //修改，根据id查询
    @RequestMapping("/getDeptById")
    public String getDeptById(Integer id, HttpServletRequest request){
        System.out.println("----DeptController----getDeptById----");
        System.out.println("id:" + id);
        request.setAttribute("dept", deptService.getDeptById(id));
        return "updateDept";
    }

    //修改，update
    @RequestMapping("/updateDept")
    public String updateDept(Dept dept){
        System.out.println("----DeptController----updateDept----");
        deptService.updateDept(dept);
        return "redirect:/dept/getAllDept";
    }

    //查询该部门下的所有职员
    @RequestMapping("/getUserByDeptId")
    public String getUserByDeptId(Integer id, HttpServletRequest request){
        System.out.println("----Dept----getUserByDeptId----");
        System.out.println("dept_id:" + id);
        request.setAttribute("userList", userService.getUserByDeptId(id));
        return "UserListForDept";
    }
}
