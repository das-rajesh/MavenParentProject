/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.mavenproject.web.controller;

import com.rajesh.mavenproject.core.dao.SkillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/home")
public class DefaultController {
    @Autowired
    SkillDao skillDao;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("skills", skillDao.getAll());
        return "index";
    }

    
}
