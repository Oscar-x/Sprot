package com.jz.table.dao;

import com.jz.table.entity.ClassInfo;
import com.jz.table.entity.Coach;
import com.jz.table.entity.Evaluate;

import java.util.List;

public interface EvaluateDao {
    //查
    List<Evaluate> FindAll();
//    //增I
    int addEvaluate(Evaluate evaluate);
//    //根据Id查，用于修改时页面回显数据
    Evaluate findById(Integer id);
    //修改
    int updateEvaluate(Evaluate evaluate);
    //删除
    int delEvaluate(Integer id);

    List<Evaluate> getEvaluationByCoachId(Integer id);

    //分页查询
    List<Evaluate> selectEvaluatePage(Integer start, Integer len);
    //总条数
    int countEvaluatePage();
}
