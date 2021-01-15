package com.jz.table.controller;


import com.jz.table.dao.ClassDao;
import com.jz.table.dao.OrderDao;
import com.jz.table.entity.ClassInfo;
import com.jz.table.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {
    @Resource
    private OrderDao orderDao;

    @RequestMapping("/orderList")//从其他页面操作后返回列表页面（重复登录）
    public String refresh(Model model){
        List<Order> orders = orderDao.FindAll();
        model.addAttribute("list",orders);
        return "user/orderList";//
    }

    @RequestMapping("/goAddOrder")//去添加页面
    public String goAddOrder(){
        return "user/addOrder";
    }
    @RequestMapping("/addOrder")//添加信息
    @ResponseBody
    public boolean addOrder(Order order){
        int i = orderDao.addOrder(order);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/goupOrder/{id}")//去修改页面，回显数据
    public String goupOrder(@PathVariable("id") int id, Model model){
        Order order =orderDao.findById(id);
        model.addAttribute("order",order);
        return "user/updateOrder";
    }

    @RequestMapping("/updateOrder")//修改
    @ResponseBody
    public boolean updateOrder(Order order){
        int i =orderDao.updateOrder(order);
        if (i>=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/godelOrder/{id}")//删除
    public String delOrder(@PathVariable("id") Integer id){
        orderDao.delOrder(id);
        return "public/Ordersc";
    }
}
