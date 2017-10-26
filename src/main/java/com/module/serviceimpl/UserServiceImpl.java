package com.module.serviceimpl;

import java.util.List;

import com.module.dao.BaseHibernateDAO;
import com.module.dao.UserDAO;
import com.module.bean.User;
import com.module.service.UserService;
public class UserServiceImpl implements UserService
{
    private UserDAO userDao;
    private BaseHibernateDAO baseHibernateDAO;

    public BaseHibernateDAO getBaseHibernateDAO() {
        return baseHibernateDAO;
    }

    public void setBaseHibernateDAO(BaseHibernateDAO baseHibernateDAO) {
        this.baseHibernateDAO = baseHibernateDAO;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public boolean login(User user)
    {
        List<User> list = this.userDao.login(user.getUsername());
        if(null !=list&&list.size()!=0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public User saveUser(User user) {
        return (User)baseHibernateDAO.saveEntity(user) ;
    }

    @Override
    public List findAll(User user) {
         List users = baseHibernateDAO.findAll(user.getClass());
         if(null != user && users.size()>0){
             return users;
         }
        return null;
    }

    @Override
    public User findUserById(String id) {
         User user = (User) baseHibernateDAO.findEntityById(User.class,id);
         if(null != user){
             return user;
         }
        return null;
    }

    @Override
    public void deleteEntityById(User user, String id) {
         baseHibernateDAO.deleteEntityById(user.getClass(),id);
    }
}
