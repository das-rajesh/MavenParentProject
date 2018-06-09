/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.mavenproject.web.controller;

import com.rajesh.mavenproject.core.dao.SkillDao;
import com.rajesh.mavenproject.core.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "admin/skills")
public class SkillController {

    @Autowired
    private SkillDao skillDao;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("skills", skillDao.getAll());
        return "admin/skills/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/skills/add";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("skill")Skill skill) {
          skillDao.save(skill);
        return "redirect:/admin/skills";
    }
    
      @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id")int id, Model model) {
        model.addAttribute("skill", skillDao.getById(id));
        return "/admin/skills/edit";
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")int id) {
//          skillDao.delete(id);
          Skill skill=skillDao.getById(id);
          skill.setDeleteFlag(true);
          skillDao.save(skill);
        return "redirect:/admin/skills";
    }
    

}
