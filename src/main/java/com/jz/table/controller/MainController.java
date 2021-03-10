package com.jz.table.controller;


import com.jz.table.dao.AdminDao;
import com.jz.table.dao.ClassDao;

import com.jz.table.dao.UserDao;
import com.jz.table.entity.Admin;
import com.jz.table.entity.ClassInfo;

import com.jz.table.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Resource
    private AdminDao ad;
    @Resource
    private UserDao ud;
    @Resource
    private ClassDao classDao;

    @RequestMapping("/qtindex")
    public String qtindex(){
        return "qtuser/qtindex";
    }

    @RequestMapping("/test")
    public String test(Model model){
        List<UserInfo> userlist = ud.FindAll();
        model.addAttribute("alist",userlist);
        return "test";
    }

    @RequestMapping("/userlogin")
    public String gouserlogin(){
        return "qtuser/userlogin";
    }
    @RequestMapping("/classs")
    public String classs(Model model){
        List<ClassInfo> classList = classDao.openClass();
        model.addAttribute("list",classList);
        return "qtuser/classs";
    }

    @RequestMapping("/fooler")
    public String fooler(){
        return "qtuser/fooler";
    }

    @RequestMapping("/tips")
    public  String tips(){
        return "qtuser/tips";
    }

    @RequestMapping("/theory")
    public  String theory(){
        return "qtuser/theorytest";
    }

    @RequestMapping("/about")
    public  String about(){
        return "qtuser/about";
    }



    @RequestMapping("login")//主页
    public String index(){
        return "admin/login";//login
    }

    @RequestMapping("/goregister")//去注册页面
    public String goregister(){
        return  "register";
    }


    @RequestMapping("/register")//注册
    @ResponseBody
    public boolean register(Admin admin){
        int i = ad.addAdmin(admin);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }



    @RequestMapping("/gologin")//登录获取用户信息存到seccion
    public String  gologin(Admin admin,HttpServletRequest request,Model model){
        Admin aa = ad.login(admin);
        if (aa==null){
            return  "public/false";
        }
        HttpSession session =  request.getSession();
        session.setAttribute("aname",admin.getName());
        session.setAttribute("apassword",admin.getPassword());
        List<UserInfo> userlist = ud.FindAll();
        model.addAttribute("admin",aa);
        model.addAttribute("alist",userlist);
        return "admin/index";//user/index
    }

    @RequestMapping("/userlist")//从其他页面操作后返回列表页面（重复登录）
    public String login(Admin admin, Model model, HttpServletRequest request){
        HttpSession session =  request.getSession();
        admin.setName((String) session.getAttribute("aname"));
        admin.setPassword((String) session.getAttribute("apassword"));
        Admin aa = ad.login(admin);
        List<UserInfo> userlist = ud.FindAll();
        model.addAttribute("admin",aa);//.往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到
        model.addAttribute("alist",userlist);
        return "user/userlist";//
    }


}