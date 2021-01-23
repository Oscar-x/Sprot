package com.jz.table.dao;


import com.jz.table.entity.UserInfo;
import org.apache.catalina.User;

import java.util.List;

public interface UserDao {
    //登录判断
    UserInfo userlogin(UserInfo userInfo);
    //查
    List<UserInfo>FindAll();
    //增
    int adduser(UserInfo user);
    //根据Id查，用于修改时页面回显数据
    UserInfo findByid(Integer id);
    //修改
    int updateUser(UserInfo user);
    //删除
    int delUser(Integer id);
    //注册
    int addusers(UserInfo user);

//    //分页查询
//    List<UserInfo> selectPage(Integer start,Integer size);
//    //总条数
//    int count();

}