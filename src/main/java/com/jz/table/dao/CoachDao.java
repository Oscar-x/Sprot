package com.jz.table.dao;

import com.jz.table.entity.ClassInfo;
import com.jz.table.entity.Coach;
import com.jz.table.entity.UserInfo;

import java.util.List;

public interface CoachDao {
    //查
    List<Coach> FindAll();
    //增I
    int addCoach(Coach coach);
    //根据Id查，用于修改时页面回显数据
    Coach findById(Integer id);
    //修改
    int updateCoach(Coach coach);
    //删除
    int delCoach(Integer id);

    //登录判断
    Coach coachLogin(Coach coach);

    List<Coach> selectCoach(Integer id);
}
