package com.module.action;

import com.module.bean.User;
import com.module.dao.BaseHibernateDAO;
import com.module.service.UserService;

public class LoginAction extends baseAction
{

    private User user;
    private UserService userService;
    private String outData;

    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getOutData() {
        return outData;
    }

    public void setOutData(String outData) {
        this.outData = outData;
    }

    protected Class getEntityClass() {
        return User.class;
    }

    public  String getEntityName(){
        return  User.class.getName();
    }
    @Override
    public String execute() throws Exception {
           return SUCCESS;
    }

    public String  userLogin(){
        boolean Flag = false;
        Flag = this.userService.login(user);
        if (Flag){
            return SUCCESS;
        }else{
            outData = "用户名或密码错误,请重新输入!";
            return ERROR;
        }
    }

}
