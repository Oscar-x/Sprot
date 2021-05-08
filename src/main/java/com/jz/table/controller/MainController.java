package com.jz.table.controller;


import com.jz.table.dao.AdminDao;
import com.jz.table.dao.ClassDao;

import com.jz.table.dao.UserDao;
import com.jz.table.entity.Admin;
import com.jz.table.entity.ClassInfo;

import com.jz.table.entity.Coach;
import com.jz.table.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
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
    private static  final  int LEN = 10;

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
//    @RequestMapping("/basketball")
//    public String basketball(Model model){
//        List<ClassInfo> classList = classDao.sortbasketball();
//        model.addAttribute("list",classList);
//        return "qtuser/classs";
//    }
//    @RequestMapping("/swin")
//    public String swin(Model model){
//        List<ClassInfo> classList = classDao.sortSwim();
//        model.addAttribute("list",classList);
//        return "qtuser/classs";
//    }
//    @RequestMapping("/longrun")
//    public String Longrun(Model model){
//        List<ClassInfo> classList = classDao.sortLongrun();
//        model.addAttribute("list",classList);
//        return "qtuser/classs";
//    }
//    @RequestMapping("/Jump")
//    public String Jump(Model model){
//        List<ClassInfo> classList = classDao.sortJump();
//        model.addAttribute("list",classList);
//        return "qtuser/classs";
//    }
//    @RequestMapping("/Pullup")
//    public String Pullup(Model model){
//        List<ClassInfo> classList = classDao.sortPullup();
//        model.addAttribute("list",classList);
//        return "qtuser/classs";
//    }
//    @RequestMapping("/Solidball")
//    public String Solidball(Model model){
//        List<ClassInfo> classList = classDao.sortSolidball();
//        model.addAttribute("list",classList);
//        return "qtuser/classs";
//    }

//    @RequestMapping("/searchClass")
//    public String searchClass(Model model){
//        List<ClassInfo> classList = classDao.searchClass();
//        model.addAttribute("list",classList);
//        return "qtuser/classs";
//    }

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
    @RequestMapping("login")//主页
    public String index(){
        return "admin/login";//login
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
    public String login(Admin admin,Integer page, Model model, HttpServletRequest request){
        System.out.println("page == > "+page);
        HttpSession session =  request.getSession();
        admin.setName((String) session.getAttribute("aname"));
        admin.setPassword((String) session.getAttribute("apassword"));
        Admin aa = ad.login(admin);
        model.addAttribute("admin",aa);//.往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到
        if (page==null){
             page = 1;
        }
        int offset = (page-1)*LEN;
        List<UserInfo> userlistPage = ud.selectPage(offset,LEN);
        int pageCount= ud.countPage();
        pageCount =(int) Math.ceil(pageCount/LEN);
        pageCount++;
        model.addAttribute("listPage",userlistPage);
        model.addAttribute("pageCount",pageCount);


        return "user/userlist";//
    }
    @RequestMapping("/searchUser/{key}")
    public String searchUser(@PathVariable("key")String key,Model model,Integer page){

        key="%"+key+"%";
        System.out.println("key--->>>"+key);
        if (page==null){
            page = 1;
        }
        int offset = (page-1)*LEN;
        List<UserInfo> userlistPage = ud.searchUser(key,offset,LEN);
        System.out.println("userlistPage == > "+userlistPage);
        int pageCount= ud.countPage();
        pageCount =(int) Math.ceil(pageCount/LEN);
        pageCount++;
        model.addAttribute("listPage",userlistPage);
        model.addAttribute("pageCount",pageCount);

        return "user/userlist";//
    }

    @RequestMapping("/basketball1")
    public String basketball1(Model model){
        List<ClassInfo> classList = classDao.sortbasketball();
        model.addAttribute("list",classList);
        return "qtuser/index";
    }

    @RequestMapping("/swin1")
    public String swin1(Model model){
        List<ClassInfo> classList = classDao.sortSwim();
        model.addAttribute("list",classList);
        return "qtuser/index";
    }
    @RequestMapping("/longrun1")
    public String Longrun1(Model model){
        List<ClassInfo> classList = classDao.sortLongrun();
        model.addAttribute("list",classList);
        return "qtuser/index";
    }
    @RequestMapping("/Jump1")
    public String Jump1(Model model){
        List<ClassInfo> classList = classDao.sortJump();
        model.addAttribute("list",classList);
        return "qtuser/index";
    }
    @RequestMapping("/Pullup1")
    public String Pullup1(Model model){
        List<ClassInfo> classList = classDao.sortPullup();
        model.addAttribute("list",classList);
        return "qtuser/index";
    }
    @RequestMapping("/Solidball1")
    public String Solidball1(Model model){
        List<ClassInfo> classList = classDao.sortSolidball();
        model.addAttribute("list",classList);
        return "qtuser/index";
    }


    @RequestMapping("/AllClass")
    public String AllClass(Model model){
        List<ClassInfo> classList = classDao.sortAllClass();
        model.addAttribute("list",classList);
        return "qtuser/index";
    }
}