package com.jz.table.controller;


import com.jz.table.dao.*;
import com.jz.table.entity.*;
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
public class UserLoginController {

    private Integer user_id;
    @Resource
    private UserDao ud;
    @Resource
    private ClassDao classDao;
    @Resource
    private ContentDao contentDao;
    @Resource
    private EvaluateDao evaluateDao;
    @Resource
    private CoachDao coachDao;
    @Resource
    private AssessDao assessDao;

    UserInfo myInfo = new UserInfo();

    @RequestMapping("/gouserregister")
    public String goadd() {
        return "qtuser/userregister";
    }

    @RequestMapping("/addUsers")
    @ResponseBody
    public boolean addUsers(UserInfo user) {
        int i = ud.addusers(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping("/gouserlogin")//登录获取用户信息存到seccion
    public String gouserlogin(UserInfo userInfo, HttpServletRequest request, Model model) {
        UserInfo aa = ud.userlogin(userInfo);
        if (aa == null) {
            return "public/false";
        }
        HttpSession session = request.getSession();
        session.setAttribute("userid", aa.getClassid());
        session.setAttribute("username", aa.getAccount());
        session.setAttribute("userpassword", aa.getUser_pwd());
        model.addAttribute("user", aa);
        myInfo = aa;
        user_id = aa.getUserid();

        List<ClassInfo> classList = classDao.openClass();
        model.addAttribute("list",classList);

        model.addAttribute("userlogon", myInfo);

        List<Content> contentList = contentDao.myClass(myInfo.getUserid());
        model.addAttribute("conlist", contentList);

        List<Assess> assessList = assessDao.getByUerId(myInfo.getUserid());
        model.addAttribute("assesslist", assessList);


        return "qtuser/index";
    }

    @RequestMapping("/joinclass/{classid}")
    public String joinclass(@PathVariable("classid") Integer classid) {
        contentDao.joinClass(classid, user_id);
        return "public/buysuccess";
    }

    @RequestMapping("/classdetails/{classid}")
    public String classdetails(@PathVariable("classid") Integer classid, Model model) {
        ClassInfo classList = classDao.findById(classid);
        model.addAttribute("alist", classList);
        return "qtuser/classdetails";
    }

    @RequestMapping("/qtindexs")//从其他页面操作后返回列表页面（重复登录）
    public String userlogin(UserInfo userInfo, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        userInfo.setAccount((String) session.getAttribute("aname"));
        userInfo.setUser_pwd((String) session.getAttribute("apassword"));
        userInfo.setUserid((Integer) session.getAttribute("auserid"));
        UserInfo aa = ud.userlogin(userInfo);
        model.addAttribute("admin", aa);
        //.往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到
        return "qtuser/qtindex";//
    }

    @RequestMapping("/myInfo")
    public String myInfo(Model model) {


        model.addAttribute("userlogon", myInfo);
        List<Content> contentList = contentDao.myClass(myInfo.getUserid());


        model.addAttribute("conlist", contentList);

        List<Assess> assessList = assessDao.getByUerId(myInfo.getUserid());
        model.addAttribute("assesslist", assessList);
        return "qtuser/myInfo";
    }

    @RequestMapping("/evaluationCoach/{coachid}")
    public String evaluationCoach(@PathVariable("coachid") Integer coachid, Model model) {
        List<Evaluate> evaluateList = evaluateDao.getEvaluationByCoachId(coachid);
        model.addAttribute("list", evaluateList);
        Coach coach = coachDao.findById(coachid);
        model.addAttribute("alist", coach);
        model.addAttribute("userid", user_id);
        model.addAttribute("coachid", coachid);
        return "qtuser/evaluationCoach";
    }

    @RequestMapping("/addEvaluate")//添加信息
    @ResponseBody
    public boolean addEvaluate(Evaluate evaluate) {
        int i = evaluateDao.addEvaluate(evaluate);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping("/index")
    public String Testindex( Model model){

        List<ClassInfo> classList = classDao.openClass();
        model.addAttribute("list",classList);

        model.addAttribute("userlogon", myInfo);

        List<Content> contentList = contentDao.myClass(myInfo.getUserid());
        model.addAttribute("conlist", contentList);

        List<Assess> assessList = assessDao.getByUerId(myInfo.getUserid());
        model.addAttribute("assesslist", assessList);

        return "qtuser/index";
    }

}

