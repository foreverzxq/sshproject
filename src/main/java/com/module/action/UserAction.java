package com.module.action;

import com.module.bean.User;
import com.module.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserAction extends baseAction {
    private int page;
    private String id;
    private User user;
    private List userList = new ArrayList();
    private UserService userService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List getUserList() {
        return userList;
    }

    public void setUserList(List userList) {
        this.userList = userList;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String findAllUser(){
        user = new User();
        userList = userService.findAll(user);
         return SUCCESS;

   }

   public  String findUserById(){
       user = userService.findUserById(id);
    return SUCCESS;
   }


}
