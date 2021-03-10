package com.jz.table.service.Impl;

import com.jz.table.dao.ClassDao;
import com.jz.table.service.ClassService;
import org.springframework.cglib.core.ClassInfo;

import javax.annotation.Resource;
import java.util.List;

public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassDao classDao;
    @Resource
    private ClassInfo classInfo;


    @Override
    public List<ClassInfo> vo() {
        return null;
    }
}
