package com.module.dao.daoimpl;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;
import com.module.bean.User;
import com.module.dao.UserDAO;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO
{
    @SuppressWarnings("unchecked")
//    @Override
    public List<User> login(String username)
    {

        String sql = "from User as user where user.username='"+username+"'";
        System.out.print(sql);
        return (List<User>) this.getHibernateTemplate().find(sql);



    }
}
