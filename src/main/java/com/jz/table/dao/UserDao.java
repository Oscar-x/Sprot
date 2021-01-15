package com.jz.table.dao;

import com.jz.table.entity.UserInfo;

import java.util.List;

public interface UserDao {
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
}