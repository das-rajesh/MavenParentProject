/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.mavenproject.core.dao.impl;

import com.rajesh.mavenproject.core.dao.SkillDao;
import com.rajesh.mavenproject.core.entity.Skill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public class SkillDaoImpl implements SkillDao{

    @Autowired
    private SessionFactory sessionFactory;
    private  Session session;
    private Transaction transaction;
    
    private void startSession(){
        session=sessionFactory.openSession();
    }
    @Override
    public List<Skill> getAll() {
        startSession();
        return session.createCriteria(Skill.class).list();
    }

    @Override
    public void save(Skill model) {

         startSession();
         transaction=session.beginTransaction();
         session.saveOrUpdate(model);
         transaction.commit();
    }

    @Override
    public boolean delete(int id) {

        startSession();
        Skill skill=getById(id);
        if(skill!=null){
            transaction=session.beginTransaction();
            session.delete(skill);
            transaction.commit();
            return true;
        }
        return false;
    }

    @Override
    public Skill getById(int id) {
              startSession();
              return (Skill) session.get(Skill.class, id);
    }
    
}
