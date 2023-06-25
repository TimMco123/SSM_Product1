package com.xiong.controller;

import com.xiong.pojo.RPType;
import com.xiong.pojo.RewardAndPunishment;
import com.xiong.pojo.User;
import com.xiong.service.RPTypeService;
import com.xiong.service.RewardAndPunishmentService;
import com.xiong.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/rp")
public class RewardAndPunishmentController {
    @Autowired
    private RewardAndPunishmentService rpService;

    @Autowired
    private RPTypeService rpTypeService;

    //查询所有，列表
    @RequestMapping("/getAllRP")
    private String getAllRP(HttpServletRequest request, HttpSession session) {
        System.out.println("----RPController----getAllRP");
        User user1 = (User) session.getAttribute("user1");
        if (user1.getRole_id() == 1) {
            request.setAttribute("rpList", rpService.getAllRP());
            return "RPList";
        } else {
            request.setAttribute("rpList", rpService.getRPById1(user1.getId()));
            return "RPList";
        }
    }

    //删除
    @RequestMapping("/delRP")
    private String delRP(Integer id) {
        System.out.println("----RPController----delRP----");
        System.out.println("id:" + id);
        rpService.delRP(id);
        return "redirect:/rp/getAllRP";
    }

    //添加
    @RequestMapping("/addRP")
    private String addRP(RewardAndPunishment rp, String date) {
        System.out.println("----RPController----addRP----");
        System.out.println("rp:" + rp + "\ndate:" + date);
        Date time = DateUtil.getDateByString(date);
        rp.setTime(time);
        System.out.println("rp:" + rp);
        rpService.addRP(rp);
        return "redirect:/rp/getAllRP";
    }

    //编辑，1，根据id查询信息
    @RequestMapping("/toUpdateRP")
    private String toUpdateRP(Integer id, HttpServletRequest request) {
        System.out.println("----RPController----toUpdateRP");
        System.out.println("id:" + id);
        request.setAttribute("rp", rpService.getRPById(id));
        request.setAttribute("rpTypeList", rpTypeService.getAllRPT());
        return "updateRP";
    }

    //编辑，2，提交
    @RequestMapping("/updateRP")
    private String updateRP(RewardAndPunishment rp, String date) {
        System.out.println("----RPController----updateRP----");
        System.out.println("rp:" + rp + "\ndate:" + date);
        Date time = DateUtil.getDateByString(date);
        rp.setTime(time);
        System.out.println("rp:" + rp);
        rpService.updateRP(rp);
        return "redirect:/rp/getAllRP";
    }
}
