package com.module.dao;

import java.util.List;
import com.module.bean.User;
public interface UserDAO 
{
    public List<User> login(String username);
}
