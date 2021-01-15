package com.jz.table.controller;

import com.jz.table.dao.AdminDao;
import com.jz.table.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    private AdminDao ad;

    @RequestMapping("/AdminList")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model){
        List<Admin> adminList = ad.FindAll();
        model.addAttribute("list",adminList);
        return "user/adminList";//
    }
    @RequestMapping("/goAddAdmin")//去添加页面
    public String goAddAdmin(){
        return "user/addAdmin";
    }
    @RequestMapping("/goAdmin")//添加信息
    @ResponseBody
    public boolean addAdmin(Admin admin){
        int i = ad.addAdmin(admin);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/goupAdmin/{id}")//去修改页面，回显数据
    public String goupAdmin(@PathVariable("id") int id, Model model){
        Admin  admin= ad.findById(id);
        model.addAttribute("admin",admin);
        return "user/updateAdmin";
    }

    @RequestMapping("/updateAdmin")//修改
    @ResponseBody
    public boolean updateCoach(Admin admin){
        int i = ad.updateAdmin(admin);
        if (i>=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/godelAdmin/{id}")//删除
    public String delUser(@PathVariable("id") Integer id){
        ad.delAdmin(id);
        return "public/Adminsc";
    }
}
