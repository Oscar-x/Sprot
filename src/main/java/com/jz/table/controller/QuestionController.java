package com.jz.table.controller;


import com.jz.table.dao.QuertionbankDao;
import com.jz.table.entity.Questionbank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class QuestionController {
    @Resource
    private QuertionbankDao quertionbankDao;

    @RequestMapping("/questionList")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model){
        List<Questionbank> questionbank = quertionbankDao.FindAll();
        model.addAttribute("list",questionbank);
        return "user/questionList";//
    }

    @RequestMapping("/goAddQuestion")//去添加页面
    public String goAddQuestion(){
        return "user/addQuestionbank";
    }
    @RequestMapping("/addQuestion")//添加信息
    @ResponseBody
    public boolean addQuestion(Questionbank questionbank){
        int i = quertionbankDao.addQuestion(questionbank);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/goupQuestion/{id}")//去修改页面，回显数据
    public String goupOrder(@PathVariable("id") int id, Model model){
        Questionbank questionbank =quertionbankDao.findById(id);
        model.addAttribute("questionbank",questionbank);
        return "user/updateQuestionbank";
    }

    @RequestMapping("/updateQuestion")//修改
    @ResponseBody
    public boolean updateQuestion(Questionbank questionbank){
        int i =quertionbankDao.updateQuestion(questionbank);
        if (i>=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/godelQuestion/{id}")//删除
    public String delQuestion(@PathVariable("id") Integer id){
        quertionbankDao.delQuestion(id);
        return "public/Questionbanksc";
    }
}
