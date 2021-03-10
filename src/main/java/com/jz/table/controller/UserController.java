package com.jz.table.controller;

import com.jz.table.dao.UserDao;
import com.jz.table.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserDao ud;

    @RequestMapping("/goadd")//去添加页面
    public String goadd(){
        return "user/addUser";
    }
    @RequestMapping("/addUser")//添加信息
    @ResponseBody
    public boolean addUser(UserInfo user){
        int i = ud.adduser(user);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/goupdate/{id}")//去修改页面，回显数据
    public String goupdate(@PathVariable("id") int id, Model model){
        UserInfo user = ud.findByid(id);
        model.addAttribute("user",user);
        return "user/updateUser";
    }

    @RequestMapping("/update")//修改
    @ResponseBody
    public boolean updateUser(UserInfo user){
        int i = ud.updateUser(user);
        if (i>=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/godel/{id}")//删除
    public String delUser(@PathVariable("id") Integer id){
        ud.delUser(id);
        return "public/success";
    }


}
