package com.jz.table.controller.coachController;


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
public class CoachClassController {

    @Resource
    private ClassDao classDao;

    @Resource
    private CoachDao coachDao;

    @Resource
    private FieldDao fieldDao;
    @Resource
    private ContentDao contentDao;
    @Resource
    private AssessDao assessDao;

    private Integer coachid;



    @RequestMapping("/coachLogin")
    public String gocoachlogin(){
        return "qtcoach/coachlogin";
    }



    @RequestMapping("/gocoachlogin")//登录获取用户信息存到seccion
    public String  gocoachlogin(Coach coach, HttpServletRequest request, Model model){
        Coach aa = coachDao.coachLogin(coach);
        if (aa == null){
            return  "public/false";
        }
        HttpSession session =  request.getSession();
        session.setAttribute("coachname",coach.getCoach_name());
        session.setAttribute("coachpassword",coach.getCoach_pwd());
        session.setAttribute("coachpassword",coach.getCoachid());
        session.setAttribute("aa",aa);
        coachid= aa.getCoachid();
        model.addAttribute("alist",aa);
        List<ClassInfo> classList = classDao.getClassByCoachId(aa.getCoachid());
        model.addAttribute("list",classList);
        List<Field> fieldList = fieldDao.FindAll();
        model.addAttribute("flist",fieldList);
        List<Content> contentList = contentDao.CoachUser(coachid);
        model.addAttribute("userlist",contentList);
        //userid=contentList.get(0).getUserid();
        return "qtcoach/index";
    }
    @RequestMapping("/coachindex")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model, HttpServletRequest request){
        List<ClassInfo> classList = classDao.getClassByCoachId(coachid);
        model.addAttribute("list",classList);
        List<Field> fieldList = fieldDao.FindAll();
        model.addAttribute("flist",fieldList);
        HttpSession session =  request.getSession();
        model.addAttribute("alist",session.getAttribute("aa"));
        List<Content> contentList = contentDao.CoachUser(coachid);
        model.addAttribute("userlist",contentList);
        return "qtcoach/coachindex";//
    }


//    @RequestMapping("/coachindexs")//从其他页面操作后返回列表页面（重复登录）
//    public String coachlogin(Coach coach, Model model, HttpServletRequest request){
//        HttpSession session =  request.getSession();
//        coach.setCoach_name((String) session.getAttribute("aname"));
//        coach.setCoach_pwd((String) session.getAttribute("apassword"));
//        Coach aa =  coachDao.coachLogin(coach);
//        model.addAttribute("alist",aa);
//        //.往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到
//        return "qtcoach/coachindex";//
//    }

    @RequestMapping("/changestatu/{classid}")
    public String changestatu(@PathVariable("classid") Integer classid){
        classDao.closeclass(classid);
        return "public/statuchange";
    }
    @RequestMapping("/DailyEvaluation/{userid}")
    public String DailyEvaluation(@PathVariable("userid") Integer userid,Model model){
        model.addAttribute("userid",userid);
        model.addAttribute("coachid",coachid);
        List<Assess> assessList=assessDao.FindAll(userid);
        model.addAttribute("assesslist",assessList);
        return "qtcoach/DailyEvaluation";
    }

    @RequestMapping("/addAssess")//添加信息
    @ResponseBody
    public boolean addAssess(Assess assess){
        int i =assessDao.addAssess(assess);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/addCoachclass")
    public String addCoachclass(Model model){
        model.addAttribute("coachid",coachid);
        System.out.println(coachid);
        return "qtcoach/coachAddclass";
    }
}
