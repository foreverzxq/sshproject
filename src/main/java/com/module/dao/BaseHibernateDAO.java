package com.module.dao;

import com.module.bean.Page;

import java.io.Serializable;
import java.util.List;

public interface BaseHibernateDAO {

    public abstract Object saveEntity(Object obj);

    public abstract Object saveEntity(String s, Object obj);

    public abstract void updateEntity(String s);

    public abstract void deleteEntity(Object obj);

    public abstract Object findEntityById(Class class1, Serializable serializable);

    public abstract List findAll(Class class1);

    public abstract void deleteEntityById(Class class1, Serializable serializable);

    public abstract List findByQuery(String s);

    public abstract void deleteAll(Class class1);

    public abstract List findByNamedQuery(String s, Object aobj[]);

    public abstract List findByNamedQuery(String s, Object obj);

    public abstract List findByNamedQueryAndNamedParam(String s, String s1, Object obj);

    public abstract List findByOutQuery(String s, Object obj);

    public abstract List findByOutQuery(String s, Object aobj[]);

    public abstract List findByNamedParam(String s, String as[], Object aobj[]);

    public abstract List findByNamedParam(String s, String s1, Object obj);

    public abstract List findByDynamicCondition(String s, List list);

    public abstract List findAllByLike(Class class1, String s, String s1);

    public abstract String[] getPropertyNamesOfEntity(Class class1);

    public abstract Page pagedQuery(String s, int i, int j);

    public abstract Page pagedQuery(String s, int i, int j, boolean flag);

    public abstract Page pagedQuery(String s, Object aobj[], int i, int j);

    public abstract Page pagedQuery(String s, Object aobj[], int i, int j, boolean flag);
}
