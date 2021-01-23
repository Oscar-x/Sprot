package com.jz.table.controller;


import com.jz.table.dao.UserDao;
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
public class UserLoginController {

    @Resource
    private UserDao ud;

    @RequestMapping("/gouserregister")
    public String goadd(){
        return "qtuser/userregister";
    }
    @RequestMapping("/addUsers")
    @ResponseBody
    public boolean addUsers(UserInfo user){
        int i = ud.addusers(user);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }



    @RequestMapping("/gouserlogin")//登录获取用户信息存到seccion
    public String  gouserlogin(UserInfo userInfo, HttpServletRequest request, Model model){
        UserInfo aa = ud.userlogin(userInfo);
        if (aa == null){
            return  "public/false";
        }
        HttpSession session =  request.getSession();
        session.setAttribute("aname",userInfo.getAccount());
        session.setAttribute("apassword",userInfo.getUser_pwd());
        List<UserInfo> userlist = ud.FindAll();
        model.addAttribute("alist",userlist);
        return "qtuser/qtindex";
    }


    @RequestMapping("/qtindexs")//从其他页面操作后返回列表页面（重复登录）
    public String userlogin(UserInfo userInfo, Model model, HttpServletRequest request){
        HttpSession session =  request.getSession();
        userInfo.setAccount((String) session.getAttribute("aname"));
        userInfo.setUser_pwd((String) session.getAttribute("apassword"));
        UserInfo aa = (UserInfo) ud.userlogin(userInfo);
        model.addAttribute("adiam",aa);
        //.往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到
        return "qtuser/qtindex";//
    }
}
