package com.jz.table.dao;


import com.jz.table.entity.Order;


import java.util.List;

public interface OrderDao {
    //查
    List<Order> FindAll();
    //增I
    int addOrder(Order order);
    //根据Id查，用于修改时页面回显数据
    Order findById(Integer id);
    //修改
    int updateOrder(Order order);
    //删除
    int delOrder(Integer id);
}
