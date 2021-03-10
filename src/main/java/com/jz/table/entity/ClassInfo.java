package com.jz.table.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClassInfo {
    private Integer classid;
    private String class_name;
    private String class_num;
    private String project;
    private Integer statu;
    private Integer coachid;
    @JsonFormat(pattern="“yyyy-MM-dd HH:mm:ss”",timezone =" “GMT+8”")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addtime;
    @JsonFormat(pattern="“yyyy-MM-dd HH:mm:ss”",timezone =" “GMT+8”")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date traintime;
    @JsonFormat(pattern="“yyyy-MM-dd HH:mm:ss”",timezone =" “GMT+8”")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataline;
    private String classgoal;
    private Integer trainnum;

    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    Coach coachs;


    public Coach getCoachs() {
        return coachs;
    }

    public void setCoachs(Coach coachs) {
        this.coachs = coachs;
    }

    public String getClassgoal() {
        return classgoal;
    }

    public void setClassgoal(String classgoal) {
        this.classgoal = classgoal;
    }



    public Integer getTrainnum() {
        return trainnum;
    }

    public void setTrainnum(Integer trainnum) {
        this.trainnum = trainnum;
    }

    private Date getDataline1() {
        return dataline;
    }

    public String getDataline() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(getDataline1());
    }

    public void setDataline(Date dataline) {
        this.dataline = dataline;
    }

    public Date getTraintime1() {
        return traintime;
    }
    public String getTraintime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(getTraintime1());
    }

    public void setTraintime(Date traintime) {
        this.traintime = traintime;
    }

    public Date getAddtime1() {
        return addtime;
    }
    public String getAddtime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(getAddtime1());
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public String getStatu() {
        if (statu==1){
            return "已开班";
        }
        else {
            return "待开班";
        }

    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
