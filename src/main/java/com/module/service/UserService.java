package com.module.service;
import com.module.bean.User;

import java.util.List;

public interface UserService
{
    public boolean login(User user);
    public User saveUser(User user);
    public List findAll(User user);
    public User findUserById(String id);
    public void deleteEntityById(User user,String id);

}
