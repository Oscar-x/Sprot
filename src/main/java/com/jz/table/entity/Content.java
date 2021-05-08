package com.jz.table.entity;

public class Content {
    private Integer id;
    private Integer userid;
    private Integer classid;
    ClassInfo classes;

    public ClassInfo getClasses() {
        return classes;
    }

    public void setClasses(ClassInfo classes) {
        this.classes = classes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}
