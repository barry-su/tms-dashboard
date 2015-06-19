/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */

package com.avp.tms.dashboard.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/status")
    public String statis(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "status";
    }

    @RequestMapping("/")
    public String index(Model model, Locale local) {
        
        return "index";
    }
}
