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

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "admin/customers")
public class CustomerController {

    @Autowired
    private CustomeraDao customerDao;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("customers", customerDao.getAll());
        return "admin/customers/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/customers/add";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("customer")Customer customer) {
          customerDao.save(customer);
        return "redirect:/admin/customers";
    }
    
      @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id")int id, Model model) {
        model.addAttribute("customer", customerDao.getById(id));
        return "/admin/customers/edit";
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")int id) {
         customerDao.delete(id);  //  permanenet delete
//          Customer customer=customerDao.getById(id);
//          customer.setDeleteFlag(true);
//          customerDao.save(customer);   // temporary delete
        return "redirect:/admin/customers";
    }
    

}
