package com.xiong.controller;

import com.xiong.pojo.Job;
import com.xiong.pojo.User;
import com.xiong.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    //查询所有
    @RequestMapping("/getAllJob")
    public String getAllJob(HttpServletRequest request, HttpSession session){
        System.out.println("----JobController----getAllJob----");
        User user1 = (User) session.getAttribute("user1");
        if(user1.getRole_id() == 1){
            request.setAttribute("jobList", jobService.getAllJob());
            return "JobList";
        }else{
            request.setAttribute("jobList", jobService.getJobById1(user1.getId()));
            return "JobList";
        }
    }

    //删除
    @RequestMapping("/delJob")
    public String delJob(Integer id){
        System.out.println("----JobController----delJob");
        jobService.delJob(id);
        return "redirect:/job/getAllJob";
    }

    //查询name是否可用
    @RequestMapping("/checkJobName")
    @ResponseBody
    public boolean checkJobName(String name){
        System.out.println("----JobController----checkJobName----");
        boolean flag = jobService.checkJobName(name);
        System.out.println("flag:" + flag);
        return flag;
    }

    //添加
    @RequestMapping("/addJob")
    public String addJob(Job job, HttpServletRequest request){
        System.out.println("----JobController----addJob----");
        System.out.println("job:" + job);
        if(jobService.checkJobName(job.getName())){
            jobService.addJob(job);
            return "redirect:/job/getAllJob";
        }else{
            request.setAttribute("msg", "职务名重复，请重试");
            request.setAttribute("returnJob", job);
            return "AddJob";
        }
    }

    //修改，根据id查询
    @RequestMapping("/getJobById")
    public String getJobById(Integer id, HttpServletRequest request){
        System.out.println("----JobController----getJobById----");
        System.out.println("id:" + id);
        request.setAttribute("job", jobService.getJobById(id));
        return "updateJob";
    }
    //修改，更新数据
    @RequestMapping("/updateJob")
    public String updateJob(Job job){
        System.out.println("----JobController----updateJob----");
        System.out.println("job:" + job);
        jobService.updateJob(job);
        return "redirect:/job/getAllJob";
    }
}
