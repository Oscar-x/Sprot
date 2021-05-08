package com.jz.table.controller;

import com.jz.table.dao.EvaluateDao;
import com.jz.table.entity.Coach;
import com.jz.table.entity.Evaluate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EvaluateController {
    @Resource
    private EvaluateDao evaluateDao;
    private static  final  int LEN = 10;

    @RequestMapping("/evaluateList")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model,Integer page){
        List<Evaluate> evaluateList = evaluateDao.FindAll();
        model.addAttribute("list",evaluateList);

        if (page==null){
            page = 1;
        }
        int offset = (page-1)*LEN;
        List<Evaluate> evaluateListPage = evaluateDao.selectEvaluatePage(offset,LEN);
        int pageCount= evaluateDao.countEvaluatePage();
        pageCount =(int) Math.ceil(pageCount/LEN);
        pageCount++;
        model.addAttribute("evaluateListPage",evaluateListPage);
        model.addAttribute("evaluatePageCount",pageCount);


        return "user/evaluateList";//
    }

    @RequestMapping("/searchEvaluate/{key}")
    public String searchEvaluate(@PathVariable("key")String key,Model model,Integer page){

        key="%"+key+"%";
        System.out.println("key--->>>"+key);
        List<Evaluate> evaluateList = evaluateDao.FindAll();
        model.addAttribute("list",evaluateList);

        if (page==null){
            page = 1;
        }
        int offset = (page-1)*LEN;
        List<Evaluate> evaluateListPage = evaluateDao.searchEvaluate(key,offset,LEN);
        int pageCount= evaluateDao.countEvaluatePage();
        pageCount =(int) Math.ceil(pageCount/LEN);
        pageCount++;
        model.addAttribute("evaluateListPage",evaluateListPage);
        model.addAttribute("evaluatePageCount",pageCount);


        return "user/evaluateList";//
    }

    @RequestMapping("/goupEvaluate/{id}")//去修改页面，回显数据
    public String goupEvaluate(@PathVariable("id") int id, Model model){
        Evaluate evaluate = evaluateDao.findById(id);
        model.addAttribute("evaluate",evaluate);
        return "user/updateEvaluate";
    }

    @RequestMapping("/updateEvaluate")//修改
    @ResponseBody
    public boolean updateEvaluate(Evaluate evaluate){
        int i =evaluateDao.updateEvaluate(evaluate);
        if (i>=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/godelEvaluate/{id}")//删除
    public String delEvaluate(@PathVariable("id") Integer id){
        evaluateDao.delEvaluate(id);
        return "public/Evaluasc";
    }
}
