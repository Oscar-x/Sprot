package com.jz.table.controller;

import com.jz.table.dao.ClassDao;
import com.jz.table.entity.ClassInfo;
import com.jz.table.entity.Coach;
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
    private static  final  int LEN = 10;
    @RequestMapping("/classList")
    public String refresh(Model model,Integer page){
        if (page==null){
            page = 1;
        }
        int offset = (page-1)*LEN;
        List<ClassInfo> classListPage = classDao.selectClassPage(offset,LEN);
        int pageCount= classDao.countClassPage();
        pageCount =(int) Math.ceil(pageCount/LEN);
        pageCount++;
        model.addAttribute("classListPage",classListPage);
        model.addAttribute("classPageCount",pageCount);
        return "user/classList";//
    }

    @RequestMapping("/searchClasss/{key}")
    public String searchClasss(@PathVariable("key")String key,Model model,Integer page){
        key="%"+key+"%";
        System.out.println("key--->>>"+key);


        if (page==null){
            page = 1;
        }
        int offset = (page-1)*LEN;
        List<ClassInfo> classListPage = classDao.searchClasss(key,offset,LEN);
        int pageCount= classDao.countClassPage();
        pageCount =(int) Math.ceil(pageCount/LEN);
        pageCount++;
        model.addAttribute("classListPage",classListPage);
        model.addAttribute("classPageCount",pageCount);
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


    @RequestMapping("/godeleteClass/{id}")//删除
    public String deleteClass(@PathVariable("id") Integer id){
        classDao.delClass(id);
        return "public/delClassSc";
    }
}
