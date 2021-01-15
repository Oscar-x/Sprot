package com.jz.table.controller;


import com.jz.table.dao.CoachDao;
import com.jz.table.entity.Coach;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CoachController {
    @Resource
    private CoachDao coachDao;

    @RequestMapping("/coachList")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model){
        List<Coach> coachList = coachDao.FindAll();
        model.addAttribute("list",coachList);
        return "user/coachList";//
    }

    @RequestMapping("/goAddCoach")//去添加页面
    public String goAddCoach(){
        return "user/addCoach";
    }
    @RequestMapping("/addCoach")//添加信息
    @ResponseBody
    public boolean addCoach(Coach coach){
        int i = coachDao.addCoach(coach);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/goupCoach/{id}")//去修改页面，回显数据
    public String goupCoach(@PathVariable("id") int id, Model model){
        Coach coach = coachDao.findById(id);
        model.addAttribute("coach",coach);
        return "user/updateCoach";
    }

    @RequestMapping("/updateCoach")//修改
    @ResponseBody
    public boolean updateCoach(Coach coach){
        int i = coachDao.updateCoach(coach);
        if (i>=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/godelCoach/{id}")//删除
    public String delUser(@PathVariable("id") Integer id){
        coachDao.delCoach(id);
        return "public/Coachsc";
    }
}
