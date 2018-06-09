/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.mavenproject.core.dao.impl;

import com.rajesh.mavenproject.core.dao.GenricDao;
import com.rajesh.mavenproject.core.entity.Skill;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dell
 */
public abstract class GenricDaoImpl<T> implements GenricDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction transaction;
    protected Class<?> persistClass;

    public GenricDaoImpl() {

        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        persistClass = (Class<?>) type.getActualTypeArguments()[0];
    }

    protected void startSession() {
        session = sessionFactory.openSession();
    }

    @Override
    public List<T> getAll() {
        startSession();
        return session.createCriteria(persistClass)
               // .add(Restrictions.eq("deleteFlag", false))
                .list();
    }

    @Override
    public T getById(int id) {
        startSession();
        return (T) session.get(persistClass, id);
    }

    @Override
    public void save(T model) {
        startSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(model);
        transaction.commit();
    }

    @Override
    public boolean delete(int id) {
        startSession();
        T model = getById(id);
        if (model != null) {
            transaction = session.beginTransaction();
            session.delete(model);
            transaction.commit();
            return true;
        }
        return false;
    }

}
