package com.module.dao.hibernate;

import com.module.bean.Page;
import com.module.dao.BaseHibernateDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class BaseHibernateDAOImpl extends HibernateDaoSupport implements BaseHibernateDAO
{
    protected final Log log = LogFactory.getLog(getClass());
    @Override
    public Object saveEntity(Object paramObject)
    {
        try
        {
            getHibernateTemplate().saveOrUpdate(paramObject);
            getHibernateTemplate().flush();
            return paramObject;
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("保存: [" + paramObject.getClass().getName() + "] 实例到数据库失败", localDataAccessException);
            throw new PersistenceException("保存 [" + paramObject.getClass().getName() + "] 实例到数据库失败", localDataAccessException);
        }
    }

    @Override
    public Object saveEntity(String paramString, Object paramObject) {
        try
        {
            getHibernateTemplate().saveOrUpdate(paramString, paramObject);
            getHibernateTemplate().flush();
            return paramObject;
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("保存: [" + paramObject.getClass().getName() + "] 实例到数据库失败", localDataAccessException);
            throw new PersistenceException("保存 [" + paramObject.getClass().getName() + "] 实例到数据库失败", localDataAccessException);
        }
    }

    @Override
    public void updateEntity(String paramString)
    {
        try
        {
            org.hibernate.classic.Session localSession = getHibernateTemplate().getSessionFactory().getCurrentSession();
            localSession.createQuery(paramString).executeUpdate();
        }
        catch (Exception localException)
        {
            this.log.error(localException);
            throw new PersistenceException("数据库操作失败", localException);
        }
    }

    @Override
    public void deleteEntity(Object paramObject)
    {
        try
        {
            getHibernateTemplate().delete(paramObject);
            getHibernateTemplate().flush();
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("从数据库删除: [" + paramObject.getClass().getName() + "] 实例失败", localDataAccessException);
            throw new PersistenceException("从数据库删除: [" + paramObject.getClass().getName() + "] 实例失败", localDataAccessException);
        }
    }

    @Override
    public Object findEntityById(Class paramClass, Serializable paramSerializable)
    {
        try
        {
            return getHibernateTemplate().get(paramClass, paramSerializable);
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("从数据库取得ID为: [" + paramSerializable + "] 的实例时失败", localDataAccessException);
            throw new PersistenceException("从数据库取得ID为: [" + paramSerializable + "] 的实例时失败", localDataAccessException);
        }
    }

    @Override
    public List findAll(Class paramClass)
    {
        try
        {
            return getHibernateTemplate().loadAll(paramClass);
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("加载所有: [" + paramClass.getName() + "] 实例时失败", localDataAccessException);
            throw new PersistenceException("加载所有: [" + paramClass.getName() + "] 实例时失败", localDataAccessException);
        }
    }
    @Override
    public void deleteEntityById(Class paramClass, Serializable paramSerializable)
    {
        try
        {
            Object localObject = findEntityById(paramClass, paramSerializable);
            if (localObject != null)
                getHibernateTemplate().delete(localObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("从数据库删除ID为: [" + paramSerializable + "] 的实例失败", localDataAccessException);
            throw new PersistenceException("从数据库删除ID为: [" + paramSerializable + "] 的实例失败", localDataAccessException);
        }
    }



    @Override
    public List findByQuery(String paramString)
    {
        try
        {
            return getHibernateTemplate().find(paramString);
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行查询语句: [" + paramString + "] 的外部查询失败", localDataAccessException);
            throw new PersistenceException("执行查询语句: [" + paramString + "] 的外部查询失败", localDataAccessException);
        }
    }

    @Override
    public void deleteAll(Class paramClass)
    {
        try
        {
            getHibernateTemplate().deleteAll(getHibernateTemplate().loadAll(paramClass));
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("从数据库删除: [" + paramClass.getName() + "] 的所有记录失败", localDataAccessException);
            throw new PersistenceException("从数据库删除: [" + paramClass.getName() + "] 的所有记录失败", localDataAccessException);
        }
    }


    @Override
    public List findByNamedQuery(String paramString, Object[] paramArrayOfObject)
    {
        try
        {
            return getHibernateTemplate().findByNamedQuery(paramString, paramArrayOfObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            StringBuffer localStringBuffer = new StringBuffer("");
            for (int i = 0; i < paramArrayOfObject.length; i++)
            {
                localStringBuffer.append(paramArrayOfObject[i]);
                localStringBuffer.append(";");
            }
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行查询名称为: [" + paramString + "] ,命名参数值为: [" + localStringBuffer + "] 的命名查询失败", localDataAccessException);
            throw new PersistenceException("执行查询名称为: [" + paramString + "] ," + "命名参数值为: [" + localStringBuffer + "] 的命名查询失败", localDataAccessException);
        }
    }
    @Override
    public List findByNamedQuery(String paramString, Object paramObject)
    {
        try
        {
            return getHibernateTemplate().findByNamedQuery(paramString, paramObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行查询名称为: [" + paramString + "] ,命名参数值为: [" + paramObject + "] 的命名查询失败", localDataAccessException);
            throw new PersistenceException("执行查询名称为: [" + paramString + "] ," + "命名参数值为: [" + paramObject + "]的命名查询失败", localDataAccessException);
        }
    }


    @Override
    public List findByNamedQueryAndNamedParam(String paramString1, String paramString2, Object paramObject)
    {
        try
        {
            return getHibernateTemplate().findByNamedQueryAndNamedParam(paramString1, paramString2, paramObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行命名参数对为: [" + paramString2 + "=" + paramObject + "] ,查询名称为: [" + paramString1 + "] 的命名查询失败", localDataAccessException);
            throw new PersistenceException("执行命名参数对为: [" + paramString2 + "=" + paramObject + "] ," + "查询名称为: [" + paramString1 + "] 的命名查询失败", localDataAccessException);
        }
    }

    @Override
    public List findByOutQuery(String paramString, Object paramObject)
    {
        try
        {
            return getHibernateTemplate().find(paramString, paramObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行查询语句为: [" + paramString + "] ,命名参数值为: [" + paramObject + "] 的外部查询失败", localDataAccessException);
            throw new PersistenceException("执行查询名称为: [" + paramString + "] ," + "命名参数值为: [" + paramObject + "] 的外部查询失败", localDataAccessException);
        }
    }

    @Override
    public List findByOutQuery(String paramString, Object[] paramArrayOfObject)
    {
        try
        {
            return getHibernateTemplate().find(paramString, paramArrayOfObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            StringBuffer localStringBuffer = new StringBuffer("");
            for (int i = 0; i < paramArrayOfObject.length; i++)
            {
                localStringBuffer.append(paramArrayOfObject[i]);
                localStringBuffer.append(";");
            }
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行查询语句为: [" + paramString + "] ,命名参数值为: [" + localStringBuffer + "] 的外部查询失败", localDataAccessException);
            throw new PersistenceException("执行查询语句为: [" + paramString + "] ," + "命名参数值为: [" + localStringBuffer + "] 的外部查询失败", localDataAccessException);
        }
    }

    @Override
    public List findByNamedParam(String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject)
    {
        try
        {
            return getHibernateTemplate().findByNamedParam(paramString, paramArrayOfString, paramArrayOfObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            StringBuffer localStringBuffer = new StringBuffer("");
            for (int i = 0; i < paramArrayOfString.length; i++)
            {
                localStringBuffer.append(paramArrayOfString[i]);
                localStringBuffer.append("=");
                localStringBuffer.append(paramArrayOfObject[i]);
                localStringBuffer.append(";");
            }
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行命名参数对为: [" + localStringBuffer + "] ,查询语句为: [" + paramString + "] 的外部查询失败", localDataAccessException);
            throw new PersistenceException("执行命名参数对为: [" + localStringBuffer + "] ,查询语句为: [" + paramString + "] 的外部查询失败", localDataAccessException);
        }
    }

    @Override
    public List findByNamedParam(String paramString1, String paramString2, Object paramObject)
    {
        try
        {
            return getHibernateTemplate().findByNamedParam(paramString1, paramString2, paramObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行命名参数对为: [" + paramString2 + "] ,查询语句为: [" + paramString1 + "] 的外部查询失败", localDataAccessException);
            throw new PersistenceException("执行命名参数对为: [" + paramString2 + "] ,查询语句为: [" + paramString1 + "] 的外部查询失败", localDataAccessException);
        }
    }

    @Override
    public List findByDynamicCondition(String paramString, List paramList)
    {
        int i = 0;
        Object[] arrayOfObject = null;
        try
        {
            i = paramList.size();
            arrayOfObject = new Object[i];
            for (int j = 0; j < i; j++)
                arrayOfObject[j] = paramList.get(j);
            return findByOutQuery(paramString, arrayOfObject);
        }
        catch (DataAccessException localDataAccessException)
        {
            StringBuffer localStringBuffer = new StringBuffer("");
            for (int k = 0; k < i; k++)
            {
                localStringBuffer.append(arrayOfObject[k]);
                localStringBuffer.append(";");
            }
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("执行查询语句为：[" + paramString + "]，查询参数值为：" + "[" + localStringBuffer + "]的动态条件查询失败：", localDataAccessException);
            throw new PersistenceException("执行查询语句为：[" + paramString + "]，" + "查询参数值为：[" + localStringBuffer + "]的动态条件查询失败：", localDataAccessException);
        }
    }

    @Override
    public List findAllByLike(Class paramClass, String paramString1, String paramString2)
    {
        org.hibernate.Session localSession = null;
        try
        {
            localSession = getSession();
            Criteria localCriteria = getSession().createCriteria(paramClass);
            localCriteria.add(Restrictions.like(paramString1, paramString2, MatchMode.ANYWHERE));
            List localList = localCriteria.list();
            return localList;
        }
        catch (Exception localException)
        {
            throw new RuntimeException(localException);
        }
        finally
        {
            if ((localSession != null) && (localSession.isOpen()))
                releaseSession(localSession);
        }
    }

    @Override
    public String[] getPropertyNamesOfEntity(Class paramClass)
    {
        try
        {
            ClassMetadata localClassMetadata = getHibernateTemplate().getSessionFactory().getClassMetadata(paramClass);
            return localClassMetadata.getPropertyNames();
        }
        catch (DataAccessException localDataAccessException)
        {
            if (this.log.isDebugEnabled())
                localDataAccessException.printStackTrace();
            else
                this.log.error("取实体：[" + paramClass.getName() + "] 的元数据失败", localDataAccessException);
            throw new PersistenceException("取得实体：[" + paramClass.getName() + "] 的元数据失败", localDataAccessException);
        }
    }


    @Override
    public Page pagedQuery(String s, int i, int j) {
        return null;
    }

    @Override
    public Page pagedQuery(String s, int i, int j, boolean flag) {
        return null;
    }

    @Override
    public Page pagedQuery(String s, Object[] aobj, int i, int j) {
        return null;
    }

    @Override
    public Page pagedQuery(String s, Object[] aobj, int i, int j, boolean flag) {
        return null;
    }
}
