package com.jz.table.dao;



import com.jz.table.entity.ClassInfo;

import java.util.List;

public interface ClassDao {
        //查
        List<ClassInfo> FindAll();
        //增I
        int addClass(ClassInfo classInfo);
        //根据Id查，用于修改时页面回显数据
        ClassInfo findById(Integer id);
        //修改
        int updateClass(ClassInfo classid);
        //删除
        int delClass(Integer id);


}
