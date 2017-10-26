package com.module.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.HibernateCallback;

import java.util.List;

public class BaseHibernateWithPageDAO extends BaseHibernateDAOImpl  {
    protected final Log log = LogFactory.getLog(getClass());
    boolean scrollResult = false;

    public boolean isScrollResult() {
        return scrollResult;
    }

    public void setScrollResult(boolean scrollResult) {
        this.scrollResult = scrollResult;
    }

    public List<Object> findByPageId(String hql,int begin, int limit)
    {
        System.out.println("hql="+hql);
        List<Object> list=(List<Object>) this.getHibernateTemplate().execute((HibernateCallback<Object>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
    }

}
