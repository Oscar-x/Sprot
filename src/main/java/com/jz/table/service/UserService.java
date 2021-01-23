package com.jz.table.service;

import com.jz.table.entity.UserInfo;

import java.util.List;

public interface UserService {

    //分页查询的实现
    List<UserInfo> findPage(Integer start,Integer size);

    //查询总条数
    Integer findCount();

}
