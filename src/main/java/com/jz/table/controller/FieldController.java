package com.jz.table.controller;



import com.jz.table.dao.FieldDao;
import com.jz.table.entity.Coach;
import com.jz.table.entity.Field;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FieldController {
    @Resource
    private FieldDao fieldDao;

    @RequestMapping("/fieldList")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model){
        List<Field> fieldList = fieldDao.FindAll();
        model.addAttribute("list",fieldList);
        return "user/fieldList";//
    }

    @RequestMapping("/goAddField")//去添加页面
    public String goAddField(){
        return "user/addField";
    }
    @RequestMapping("/addField")//添加信息
    @ResponseBody
    public boolean addCoach(Field field){
        int i = fieldDao.addField(field);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/goupField/{id}")//去修改页面，回显数据
    public String goupField(@PathVariable("id") int id, Model model){
        Field field = fieldDao.findById(id);
        model.addAttribute("field",field);
        return "user/updateField";
    }

    @RequestMapping("/updateField")//修改
    @ResponseBody
    public boolean updateField(Field field){
        int i =fieldDao.updateField(field);
        if (i>=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/godelField/{id}")//删除
    public String delField(@PathVariable("id") Integer id){
        fieldDao.delField(id);
        return "public/Fieldsc";
    }
}
