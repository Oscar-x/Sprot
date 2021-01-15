package com.jz.table.entity;

public class Coach {
    private Integer coachid;
    private String coach_name;
    private String coach_pwd;
    private String coach_sex;
    private String touch_project;
    private String phone;
    private String email;

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public String getCoach_name() {
        return coach_name;
    }

    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    public String getCoach_pwd() {
        return coach_pwd;
    }

    public void setCoach_pwd(String coach_pwd) {
        this.coach_pwd = coach_pwd;
    }

    public String getCoach_sex() {
        return coach_sex;
    }

    public void setCoach_sex(String coach_sex) {
        this.coach_sex = coach_sex;
    }

    public String getTouch_project() {
        return touch_project;
    }

    public void setTouch_project(String touch_project) {
        this.touch_project = touch_project;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
