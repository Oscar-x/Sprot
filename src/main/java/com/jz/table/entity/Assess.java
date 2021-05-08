package com.jz.table.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Assess {
    private Integer id;
    private Integer coachid;
    private Integer userid;
    private String content;
    @JsonFormat(pattern="“yyyy-MM-dd HH:mm:ss”",timezone =" “GMT+8”")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;
    Coach coaches;

    public Coach getCoaches() {
        return coaches;
    }

    public void setCoaches(Coach coaches) {
        this.coaches = coaches;
    }

    public Date getUpdatetime1() {
        return updatetime;
    }

    public String getUpdatetime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(getUpdatetime1());
    }

    List<UserInfo> users;

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }


    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
