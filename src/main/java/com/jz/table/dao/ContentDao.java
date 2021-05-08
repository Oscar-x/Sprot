package com.jz.table.dao;


import com.jz.table.entity.Content;

import java.util.List;

public interface ContentDao {

    List<Content> myClass(Integer id);

    int joinClass(Integer classid,Integer userid);

    List<Content> CoachUser(Integer id);
}
