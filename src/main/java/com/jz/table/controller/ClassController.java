package com.jz.table.controller;

import com.jz.table.dao.ClassDao;
import com.jz.table.entity.ClassInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class ClassController {
    @Resource
    private ClassDao classDao;

    @RequestMapping("/classList")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model){
        List<ClassInfo> classList = classDao.FindAll();
        model.addAttribute("list",classList);
        return "user/classList";//
    }

    @RequestMapping("/goAddClass")//去添加页面
    public String goAddClass(){
        return "user/addClass";
    }
    @RequestMapping("/addClass")//添加信息
    @ResponseBody
    public boolean addClass(ClassInfo classInfo){
        int i = classDao.addClass(classInfo);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/goupClass/{id}")//去修改页面，回显数据
    public String goupClass(@PathVariable("id") int id, Model model){
        ClassInfo classInfo = classDao.findById(id);
        model.addAttribute("class",classInfo);
        return "user/updateClass";
    }

    @RequestMapping("/updateClass")//修改
    @ResponseBody
    public boolean updateClass(ClassInfo classInfo){
        int i =classDao.updateClass(classInfo);
        if (i>=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/godelClass/{id}")//删除
    public String delClass(@PathVariable("id") Integer id){
        classDao.delClass(id);
        return "public/Classsc";
    }
}
