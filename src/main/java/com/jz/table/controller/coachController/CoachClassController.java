package com.jz.table.controller.coachController;


import com.jz.table.dao.ClassDao;
import com.jz.table.dao.CoachDao;
import com.jz.table.dao.FieldDao;
import com.jz.table.entity.ClassInfo;
import com.jz.table.entity.Coach;
import com.jz.table.entity.Field;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/coachlogin")
    public String gocoachlogin(){
        return "qtcoach/coachlogin";
    }

    @RequestMapping("/addCoachclass")
    public String addCoachclass(){
        return "qtcoach/coachAddclass";
    }

    @RequestMapping("/coachindex")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model){
        List<ClassInfo> classList = classDao.FindAll();
        model.addAttribute("list",classList);
        List<Field> fieldList = fieldDao.FindAll();
        model.addAttribute("flist",fieldList);
        return "qtcoach/coachindex";//
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
        model.addAttribute("alist",aa);
        List<ClassInfo> classList = classDao.getClassByCoachId(aa.getCoachid());
        model.addAttribute("list",classList);
        List<Field> fieldList = fieldDao.FindAll();
        model.addAttribute("flist",fieldList);
        return "qtcoach/coachindex";
    }


    @RequestMapping("/coachindexs")//从其他页面操作后返回列表页面（重复登录）
    public String coachlogin(Coach coach, Model model, HttpServletRequest request){
        HttpSession session =  request.getSession();
        coach.setCoach_name((String) session.getAttribute("aname"));
        coach.setCoach_pwd((String) session.getAttribute("apassword"));
        Coach aa =  coachDao.coachLogin(coach);
        model.addAttribute("alist",aa);
        //.往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到
        return "qtcoach/coachindex";//
    }
    @RequestMapping("/changestatu/{classid}")//加入班级
    public String changestatu(@PathVariable("classid") Integer classid){
        classDao.closeclass(classid);
        return "public/statuchange";
    }
}
