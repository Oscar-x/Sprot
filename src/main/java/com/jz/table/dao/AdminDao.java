package com.jz.table.dao;

import com.jz.table.entity.Admin;

import java.util.List;


public interface AdminDao {
    //登录判断
    Admin login(Admin admin);
    //注册
    int addAdmin(Admin admin);
    //查
    List<Admin> FindAll();
    //根据id查找
    Admin findById(Integer id);
    //修改
    int updateAdmin(Admin admin);
    //删除
    int delAdmin(Integer id);

    //分页查询
    List<Admin> selectAdminPage(Integer start, Integer len);
    //总条数
    int countAdminPage();
}