package com.jz.table.dao;

import com.jz.table.entity.Assess;


import java.util.List;

public interface AssessDao {
    //查
    List<Assess> FindAll(Integer userid);
    //    //增I
    int addAssess(Assess assess);

    List<Assess> getByUerId(Integer id);

}
