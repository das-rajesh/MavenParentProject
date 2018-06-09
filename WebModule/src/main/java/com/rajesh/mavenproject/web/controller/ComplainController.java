/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.mavenproject.web.controller;

import com.rajesh.mavenproject.core.dao.CustomeraDao;
import com.rajesh.mavenproject.core.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "admin/complains")
public class ComplainController {

    @Autowired
    private CustomeraDao complainDao;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("complains", complainDao.getAll());
        return "admin/complains/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/complains/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@ModelAttribute("complain")Customer complain) {
          complainDao.save(complain);
        return "success";
    }
    
      @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id")int id, Model model) {
        model.addAttribute("complain", complainDao.getById(id));
        return "/admin/complains/edit";
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")int id) {
         complainDao.delete(id);  //  permanenet delete
     return "redirect:/admin/complains";
    }
    

}
