package com.jz.table.dao;

import com.jz.table.entity.Coach;
import com.jz.table.entity.Field;

import java.util.List;

public interface FieldDao {
    //查
    List<Field> FindAll();
    //增I
    int addField(Field field);
    //根据Id查，用于修改时页面回显数据
    Field findById(Integer id);
    //修改
    int updateField(Field field);
    //删除
    int delField(Integer id);

    //分页查询
    List<Field> selectFieldPage(Integer start,Integer len);
    //总条数
    int countFieldPage();
}
