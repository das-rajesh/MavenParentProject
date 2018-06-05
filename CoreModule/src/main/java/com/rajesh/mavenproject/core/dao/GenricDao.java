/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.mavenproject.core.dao;

import java.util.List;

/**
 *
 * @author Dell
 */
public interface GenricDao<T> {
    
    List<T> getAll();
    void save(T model);
    boolean delete(int id);
    T getById(int id);
    
}
