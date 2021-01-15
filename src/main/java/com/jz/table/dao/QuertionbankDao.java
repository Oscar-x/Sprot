package com.jz.table.dao;

import com.jz.table.entity.Questionbank;

import java.util.List;

public interface QuertionbankDao {
    //查
    List<Questionbank> FindAll();
    //增I
    int addQuestion(Questionbank questionbank);
    //根据Id查，用于修改时页面回显数据
    Questionbank findById(Integer id);
    //修改
    int updateQuestion(Questionbank order);
    //删除
    int delQuestion(Integer id);
}
