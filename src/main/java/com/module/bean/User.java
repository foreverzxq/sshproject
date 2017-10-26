package com.module.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User
{
    private String userid;
    private String username;
    private String password;
    private String sex;
    private int age;
    private Date brithdate;
    private String update_time;
    private String adress;

    public String getEntityClassName() {
        return User.class.getName();
    }

    //集合属性，保留该对象关联的所有女朋友
    private List<String> girlFriend  = new ArrayList<String>();

    public List<String> getGirlFriend()
    {
         return  girlFriend;
    }
    public void setGirlFriend()
    {
        this.girlFriend = girlFriend;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBrithdate() {
        return brithdate;
    }

    public void setBrithdate(Date brithdate) {
        this.brithdate = brithdate;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
